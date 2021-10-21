package hu.bme.aut.temalabor.webshop.repository;

import java.util.List;

import hu.bme.aut.temalabor.webshop.model.Product;

public interface ProductRepository {

    public Product save(Product product);
    
    public List<Product> findByName(String name);
    
    public void delete(Product product);
}
