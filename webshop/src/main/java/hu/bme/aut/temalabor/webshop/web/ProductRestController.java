package hu.bme.aut.temalabor.webshop.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.bme.aut.temalabor.webshop.dto.ProductDto;
import hu.bme.aut.temalabor.webshop.mapper.ProductMapper;
import hu.bme.aut.temalabor.webshop.model.Category;
import hu.bme.aut.temalabor.webshop.model.Product;
import hu.bme.aut.temalabor.webshop.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;
    
    //1. megoldás: REST API-n is entitások utaznak, de gondoskodunk a körmentes JSON-ról
//    @GetMapping
//    public List<Product> findAll(){
//        List<Product> products = productRepository.findAll();
//        products.forEach(this::setUnneededProductFieldsToNull);
//        
//        return products;
//    }
//    
//    private void setUnneededProductFieldsToNull(Product product) {
//        Category category = product.getCategory();
//        if(category != null)
//            category.setProducts(null);
//    }
    
    
    @GetMapping
    public List<ProductDto> findAll() {
        List<Product> products = productRepository.findAllWithCategoryProducts();
        

        return productMapper.productsToDtos(products);
    }
    
    
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
