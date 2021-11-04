package hu.bme.aut.temalabor.webshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    
    
    public void addProduct(Product product) {
        if(this.products == null)
            this.products = new ArrayList<>();
        
        this.products.add(product);
        product.setCategory(this);
    }
    
}
