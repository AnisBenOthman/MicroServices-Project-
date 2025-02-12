package tn.esprit.spring.firstms.Entities;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import tn.esprit.spring.firstms.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(target = "quantity", ignore = true)
    ProductDTO productToProductDTO(Product product);

    Product ProductDTOToProduct(ProductDTO productDTO);
}
