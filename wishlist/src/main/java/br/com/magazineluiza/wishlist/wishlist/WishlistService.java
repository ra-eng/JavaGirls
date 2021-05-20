package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.*;
import br.com.magazineluiza.wishlist.exception.MaximumSizeException;
import br.com.magazineluiza.wishlist.product.Product;
import br.com.magazineluiza.wishlist.product.ProductDTO;
import br.com.magazineluiza.wishlist.product.ProductMapper;
import br.com.magazineluiza.wishlist.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Client addProduct(Integer clientId, Integer productId) throws MaximumSizeException {
        int maximumProducts = 20;
        Client client = clientService.findBy(clientId);
        Product product = productService.findBy(productId);
        if(client.getProducts().size() == maximumProducts) throw new MaximumSizeException();
        client.addProduct(product);
        return clientService.addClient(client);
    }

    public ClientDTO getProductsBy(Integer clientId) {
        Client client = clientService.findBy(clientId);
        return clientMapper.toClientDTO(client);
    }

    public void deleteProduct(Integer clientId, Integer productId) {
        Client client = clientService.findBy(clientId);
        for (Product product : client.getProducts()){
            if (product.getId().equals(productId)) clientRepository.removeProduct(productId);
        }
    }

    public List<ProductDTO> getProductsByName(String productName, Integer clientId) {
        ClientDTO clientDTO = clientMapper.toClientDTO(clientService.findBy(clientId));
        List<ProductDTO> products = productMapper.toProductDTO(clientDTO.getProducts());
        return products.stream().filter(p -> p.getName().toLowerCase()
                .equals(productName.toLowerCase())).collect(Collectors.toList());
    }
}
