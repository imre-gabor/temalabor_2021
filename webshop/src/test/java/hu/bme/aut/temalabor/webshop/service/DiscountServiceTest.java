package hu.bme.aut.temalabor.webshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import hu.bme.aut.temalabor.webshop.model.Category;
import hu.bme.aut.temalabor.webshop.model.Product;
import hu.bme.aut.temalabor.webshop.repository.CategoryRepository;
import hu.bme.aut.temalabor.webshop.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class DiscountServiceTest {

    @InjectMocks
    DiscountService discountService;

    @Mock
    ProductRepository productRepository;
    
    @Mock
    CategoryRepository categoryRepository;
    
    @Test
    public void testDiscountProductsInCategory() {
        
        //ARRANGE
        Category category = new Category("abcd");
        category.addProduct(new Product(1L, "x", 100.0, null));
        category.addProduct(new Product(2L, "y", 200.0, null));
        when(categoryRepository.findByName("abcd")).thenReturn(Arrays.asList(category));
        
        //ACT
        discountService.discountProductsInCategory("abcd", 10);
        
        //ASSERT
        List<Product> products = category.getProducts();
        assertThat(products.get(0).getPrice()).isCloseTo(90.0, Offset.offset(0.000001));
        assertThat(products.get(1).getPrice()).isCloseTo(180.0, Offset.offset(0.000001));
    }
    
}
