package br.com.magazineluiza.wishlist.mapper;

import java.util.List;

import br.com.magazineluiza.wishlist.dto.ProductDTO;
import br.com.magazineluiza.wishlist.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  Product toProduct(ProductDTO productDTO);

  ProductDTO toProductDTO(Product product);

  List<ProductDTO> toProductDTO(List<Product> products);

  Iterable<ProductDTO> toProductDTO(Iterable<Product> products);
}
