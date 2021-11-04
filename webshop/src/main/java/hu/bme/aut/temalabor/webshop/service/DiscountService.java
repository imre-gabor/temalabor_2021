package hu.bme.aut.temalabor.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.bme.aut.temalabor.webshop.model.Category;
import hu.bme.aut.temalabor.webshop.repository.CategoryRepository;
import hu.bme.aut.temalabor.webshop.repository.ProductRepository;

@Service
public class DiscountService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public void discountProductsInCategory(String name, int percent) {
        
        List<Category> categories = categoryRepository.findByName(name);
        categories.forEach(c -> {
            c.getProducts().forEach(p ->{
                p.setPrice(p.getPrice() / 100.0 * (100 - percent));
                productRepository.save(p);
            });
        });
        
    }

}
