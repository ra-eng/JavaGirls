package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.client.Client;
import br.com.magazineluiza.wishlist.wishlist.Wishlist;
import br.com.magazineluiza.wishlist.wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    public static ProductDTO getDtoFromProduct(Product product) {
        return new ProductDTO(product);
    }

    public void addProductToWishlist(Product product, Client client) {
        Optional<Wishlist> wishlist = wishlistRepository.findById(client.getWishlist().getId());

        wishlist.get().addProduto(product);

        wishlistRepository.save(wishlist.get());
    }

    public void addProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO);
        productRepository.save(product);
    }

    public List<ProductDTO> getProducts()  {
        List<Product> products = productRepository.findAll();
        return ProductDTO.converter(products);
    }

    public Product findProduct(Integer productId){
        Optional<Product> product = productRepository.findById(productId);
        return Optional.ofNullable(product).get().get();
    }
}
