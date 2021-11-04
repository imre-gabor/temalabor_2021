package hu.bme.aut.temalabor.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    
    @ManyToOne
    private Category category;
}
