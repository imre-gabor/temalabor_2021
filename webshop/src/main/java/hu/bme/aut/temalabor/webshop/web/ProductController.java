package hu.bme.aut.temalabor.webshop.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.bme.aut.temalabor.webshop.model.Product;
import hu.bme.aut.temalabor.webshop.repository.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    
    
    @GetMapping("/")
    public String home(Map<String, Object> model) {
        List<Product> products = productRepository.findAll();
        model.put("products", products);
        model.put("product", new Product());
        
        return "productPage";
    }
    
    @PostMapping("/createProduct")
    public String createProduct(Product product) {
        productRepository.save(product);
        return "redirect:/";
    }
}
