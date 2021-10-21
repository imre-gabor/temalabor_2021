package hu.bme.aut.temalabor.webshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private Long id;
    private String name;
    private double price;
    
    private Category category;
}
