package hu.bme.aut.temalabor.webshop.repository;

import java.util.List;

import hu.bme.aut.temalabor.webshop.model.Category;

public interface CategoryRepository {

    public List<Category> findByName(String name);
    
}
