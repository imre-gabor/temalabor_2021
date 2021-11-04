package hu.bme.aut.temalabor.webshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bme.aut.temalabor.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    public List<Product> findByName(String name);
    
}
