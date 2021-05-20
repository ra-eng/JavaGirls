package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.*;
import br.com.magazineluiza.wishlist.common.ApiResponse;
import br.com.magazineluiza.wishlist.exception.IdAlreadyAddedException;
import br.com.magazineluiza.wishlist.exception.MaximumSizeException;
import br.com.magazineluiza.wishlist.product.Product;
import br.com.magazineluiza.wishlist.product.ProductDTO;
import br.com.magazineluiza.wishlist.product.ProductMapper;
import br.com.magazineluiza.wishlist.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class WishlistService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<ApiResponse> addProduct(Integer clientId, Integer productId) {
        int maximumProducts = 20;
        Client client = null;
        Product product = null;

        try {
            client = clientService.findBy(clientId);
            product = productService.findBy(productId);

            for (Product p: client.getProducts()) {
                if (p.getId().equals(productId)) throw new IdAlreadyAddedException(productId);
            }

            if(client.getProducts().size() == maximumProducts) throw new MaximumSizeException(maximumProducts);

            client.addProduct(product);
            clientService.addClient(client);

        } catch (RuntimeException e){
            if (client == null) return new ResponseEntity<ApiResponse>(new ApiResponse(false, String.format("No client id %d present", clientId)), HttpStatus.NOT_FOUND);
            if (product == null) return new ResponseEntity<ApiResponse>(new ApiResponse(false, String.format("No product id %d present", productId)), HttpStatus.NOT_FOUND);
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been added to Wishlist"), HttpStatus.CREATED);
    }

    public ResponseEntity<?> getProductsBy(Integer clientId) {
        ClientDTO client = null;
        try {
            client = clientMapper.toClientDTO(clientService.findBy(clientId));
        } catch (RuntimeException e){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ClientDTO>(client, HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse> deleteProduct(Integer clientId, Integer productId) {
        Client client = null;
        List<Product> products = null;

        try {
            client = clientService.findBy(clientId);
            products = client.getProducts();
            if (products.size() == 0) return new ResponseEntity<ApiResponse>(
                    new ApiResponse(false, String.format("Client doesn't any products on the wishlist", productId)), HttpStatus.NOT_FOUND);

            for (Product product : products) {
                if (product.getId().equals(productId)) {
                    clientRepository.removeProduct(productId);
                    return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been deleted from Wishlist"), HttpStatus.OK);
                }
            }
        } catch (RuntimeException e){
            if (client == null) return new ResponseEntity<ApiResponse>(new ApiResponse(false, String.format("No client id %d present", clientId)), HttpStatus.NOT_FOUND);
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ApiResponse>(new ApiResponse(false, String.format("No product id %d present", productId)), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<ProductDTO>> getProductsByName(String productName, Integer clientId) {
        ClientDTO clientDTO = clientMapper.toClientDTO(clientService.findBy(clientId));
        List<ProductDTO> products = productMapper.toProductDTO(clientDTO.getProducts());
        List<ProductDTO> collect = products.stream().filter(p -> p.getName().toLowerCase()
                .equals(productName.toLowerCase())).collect(Collectors.toList());

        return new ResponseEntity<List<ProductDTO>>(collect, HttpStatus.OK);
    }
}
