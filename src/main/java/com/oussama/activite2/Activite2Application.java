package com.oussama.activite2;

import com.oussama.activite2.entities.Product;
import com.oussama.activite2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Activite2Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(Activite2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      productRepository.save(new Product(null,"TV",5500,3));
      productRepository.save(new Product(null,"Computer",3500,13));
      productRepository.save(new Product(null,"Smart Phone",15500,300));

      List<Product> products= productRepository.findAll();
      products.forEach(p->{
          System.out.println(p.toString());
      });

      Product product=productRepository.findById(Long.valueOf(1)).get();
        System.out.println("-------------------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("-----------------");
        product.setName("TV1");
        product.setPrice(3200);
        product.setQuantity(1);

        System.out.println("-------MODIFICATION---------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("---------------------");

        productRepository.deleteById(Long.valueOf(1));

        System.out.println("---------Suppression----------");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("----------------------");

        System.out.println("-------Chercher-Produit----------");
        List<Product> pr= productRepository.findByNameAndPrice("Computer",3500);
        pr.forEach(p->{
            System.out.println(p.toString());
        });


    }
}
