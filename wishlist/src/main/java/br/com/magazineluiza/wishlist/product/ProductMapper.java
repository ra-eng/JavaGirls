package br.com.magazineluiza.wishlist.product;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductDTO productDTO);
    List<ProductDTO> toProductDTO(List<Product> products);
    Iterable<ProductDTO> toProductDTO(Iterable<Product> products);
}
