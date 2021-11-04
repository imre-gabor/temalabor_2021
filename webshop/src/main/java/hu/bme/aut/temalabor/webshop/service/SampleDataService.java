package hu.bme.aut.temalabor.webshop.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.bme.aut.temalabor.webshop.model.Category;
import hu.bme.aut.temalabor.webshop.model.Product;
import hu.bme.aut.temalabor.webshop.repository.CategoryRepository;
import hu.bme.aut.temalabor.webshop.repository.ProductRepository;

@Service
public class SampleDataService {

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Transactional
    public void addSampleData() {
        Category category = new Category("AAA");
        Category savedCategory = categoryRepository.save(category);
        
        Product product1 = new Product(null, "prod1", 100.0, null);
        savedCategory.addProduct(product1);
        Product product2 = new Product(null, "prod2", 100.0, null);
        savedCategory.addProduct(product2);
        productRepository.saveAll(Arrays.asList(product1, product2));
    }
}
