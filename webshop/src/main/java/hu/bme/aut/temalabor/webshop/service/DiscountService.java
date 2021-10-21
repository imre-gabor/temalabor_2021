package hu.bme.aut.temalabor.webshop.service;

import java.util.List;

import hu.bme.aut.temalabor.webshop.model.Category;
import hu.bme.aut.temalabor.webshop.repository.CategoryRepository;
import hu.bme.aut.temalabor.webshop.repository.ProductRepository;

public class DiscountService {
    
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    
    public void discountProductsInCategory(String name, int percent) {
        
        List<Category> categories = categoryRepository.findByName(name);
        categories.forEach(c -> {
            c.getProducts().forEach(p ->{
                p.setPrice(p.getPrice() / 100.0 * (100 + percent));
                productRepository.save(p);
            });
        });
        
    }

}
