package hu.bme.aut.temalabor.webshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hu.bme.aut.temalabor.webshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByName(String name);
    
}
