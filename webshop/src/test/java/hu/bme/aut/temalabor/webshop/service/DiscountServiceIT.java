package hu.bme.aut.temalabor.webshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hu.bme.aut.temalabor.webshop.model.Category;
import hu.bme.aut.temalabor.webshop.model.Product;
import hu.bme.aut.temalabor.webshop.repository.CategoryRepository;
import hu.bme.aut.temalabor.webshop.repository.ProductRepository;

@SpringBootTest
@AutoConfigureTestDatabase
//@Transactional
/*
 * Transactional Előnyök: 
 * 1. LazyInitException elkerülése (a tesztben DB-ből betöltött entitások mind menedzseltek, 
 * így a lazy kapcsolatok be tudnak töltődni.
 * 2. Minden teszt metódus végén rollback --> nem marad hátra szemét a DB-ben, ami más teszt metódus sikerességét befolyásolhatná
 * Hátrány:
 * 1. Elfedi az olyan hibákat, amik a kapcsolatok nem megfelelő betöltéséből adódnak.
 * 2. Elfedi az üzleti logikában esetleg hiányzó @Transactional annotációt.
 * 3. Az üzleti logika @Transactional metódusai lehet, hogy nem flush-olódnak DB-be. (rollback a végén, nem commit)
 */
public class DiscountServiceIT {

    @Autowired
    DiscountService discountService;

    @Autowired
    ProductRepository productRepository;
    
    @Autowired
    CategoryRepository categoryRepository;
    
    @BeforeEach
    public void init() {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }
    
    @Test
    public void testDiscountProductsInCategory() {
        
        //ARRANGE
        Category category = new Category("abcd");
        categoryRepository.save(category);
        
        Product product1 = new Product(null, "x", 100.0, null);
        category.addProduct(product1);
        Product product2 = new Product(null, "y", 200.0, null);
        category.addProduct(product2);
        productRepository.save(product1);
        productRepository.save(product2);
        
        //ACT
        discountService.discountProductsInCategory("abcd", 10);
        
        //ASSERT
//        Category categoryFromDb = categoryRepository.findById(category.getId()).get();
        Category categoryFromDb = categoryRepository.findByIdWithProducts(category.getId()).get();
        List<Product> products = categoryFromDb.getProducts();
        assertThat(products.get(0).getPrice()).isCloseTo(90.0, Offset.offset(0.000001));
        assertThat(products.get(1).getPrice()).isCloseTo(180.0, Offset.offset(0.000001));
    }
    
}
