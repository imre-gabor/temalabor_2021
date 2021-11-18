package hu.bme.aut.temalabor.webshop.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDto {
    
    private long id;
    private String name;

    private List<ProductDto> products;
}
