package hu.bme.aut.temalabor.webshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.bme.aut.temalabor.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    public List<Product> findByName(String name);
    
    @EntityGraph(attributePaths = "category.products")
    @Query("SELECT p FROM Product p")
    public List<Product> findAllWithCategoryProducts();
    
}
