package hu.bme.aut.temalabor.webshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import hu.bme.aut.temalabor.webshop.dto.CategoryDto;
import hu.bme.aut.temalabor.webshop.dto.ProductDto;
import hu.bme.aut.temalabor.webshop.model.Category;
import hu.bme.aut.temalabor.webshop.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    public ProductDto productToDto(Product product);
    public List<ProductDto> productsToDtos(List<Product> products);
    
    @Mapping(target = "products", ignore = true)
    public CategoryDto categoryToDto(Category category);
}
