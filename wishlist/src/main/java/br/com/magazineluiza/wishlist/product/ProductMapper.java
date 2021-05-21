package br.com.magazineluiza.wishlist.product;

import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  Product toProduct(ProductDTO productDTO);

  List<ProductDTO> toProductDTO(List<Product> products);

  Iterable<ProductDTO> toProductDTO(Iterable<Product> products);
}
