package hu.bme.aut.temalabor.webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.bme.aut.temalabor.webshop.service.SampleDataService;

@SpringBootApplication
public class WebshopApplication implements CommandLineRunner {
    
    @Autowired
    SampleDataService sampleDataService;

    public static void main(String[] args) {
        SpringApplication.run(WebshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        sampleDataService.addSampleData();
    }
}
