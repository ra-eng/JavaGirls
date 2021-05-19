package br.com.magazineluiza.wishlist.product;

import br.com.magazineluiza.wishlist.product.Product;
import br.com.magazineluiza.wishlist.product.ProductDTO;

import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductDTO productDTO);

    Set<ProductDTO> toProductDTO(Set<Product> products);

    Iterable<ProductDTO> toProductDTO(Iterable<Product> products);
}
