package hu.bme.aut.temalabor.webshop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import hu.bme.aut.temalabor.webshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.products")
    public Optional<Category> findByIdWithProducts(Long id);
    
    public List<Category> findByName(String name);
    
}
