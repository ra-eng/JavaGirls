package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.client.Client;
import br.com.magazineluiza.wishlist.client.ClientService;
import br.com.magazineluiza.wishlist.exception.MaximumSizeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductMapper productMapper;

    public void addProductToWishlist(Integer clientId, Integer productId) throws MaximumSizeException {
        Client client = clientService.findClient(clientId);
        Product product = findProduct(productId);

        if(client.getWishlist().getProducts().size() == 20){
            throw new MaximumSizeException();
        }

        product.getWishlists().add(client.getWishlist());

        productRepository.save(product);
    }

    public void addProduct(ProductDTO productDTO) {
        Product product = productMapper.toProduct(productDTO);
        productRepository.save(product);
    }

    public List<ProductDTO> getProducts()  {
        List<Product> products = productRepository.findAll();
        return productMapper.toProducts(products);
    }

    public List<ProductDTO> getProducts(Client client)  {
        List<Product> products = client.getWishlist().getProducts();
        return productMapper.toProducts(products);
    }

    public Product findProduct(Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        return Optional.of(product).get().get();
    }

    public void deleteProduct(Client client, Product product) {
        List<Product> products = client.getWishlist().getProducts();
        for (Product pro: products) {
            if(pro.getId().equals(product.getId())) productRepository.deleteProductById(product.getId());
        }
    }

    public List<ProductDTO> getProductByName(Client client, String name) {
        List<Product> products = client.getWishlist().getProducts();
        List<Product> productList = products.stream().filter(p -> p.getName().
                toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        return productMapper.toProducts(productList);
    }
}
