package hu.bme.aut.temalabor.webshop.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {

    private long id;
    private String name;
    
    private List<Product> products;
    
    
    public void addProduct(Product product) {
        if(this.products == null)
            this.products = new ArrayList<>();
        
        this.products.add(product);
        product.setCategory(this);
    }
    
}