package hu.bme.aut.temalabor.webshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private double price;
    
    private CategoryDto category;
}
