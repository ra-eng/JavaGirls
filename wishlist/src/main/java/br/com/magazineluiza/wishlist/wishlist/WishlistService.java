package br.com.magazineluiza.wishlist.wishlist;

import br.com.magazineluiza.wishlist.client.Client;
import br.com.magazineluiza.wishlist.client.ClientRepository;
import br.com.magazineluiza.wishlist.client.ClientService;
import br.com.magazineluiza.wishlist.exception.MaximumSizeException;
import br.com.magazineluiza.wishlist.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class WishlistService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

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

    public Set<ProductDTO> getProductsBy(Integer clientId) {
        Client client = clientService.findBy(clientId);
        return productMapper.toProductDTO(client.getProducts());
    }

    public void deleteProduct(Integer clientId, Integer productId) {
        Client client = clientService.findBy(clientId);
        for (Product product : client.getProducts()){
            if (product.getId().equals(productId)) clientRepository.deleteInProductsId(productId);
        }

    }
}
