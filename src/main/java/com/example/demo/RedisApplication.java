package com.example.demo;

import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.ProductDAO;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo.repository")
@RestController
@RequestMapping("/product")
public class RedisApplication {

	@Autowired
	private ProductDAO productDAO;

	@PostMapping
	public Product save(@RequestBody Product product){
		return productDAO.save(product);
	}

	@GetMapping
	public List<Product> getAllProducts(){
		return productDAO.findAll();
	}

	@GetMapping("/{id}")
	public Product findProduct(@PathVariable int id){
		return productDAO.findProductById(id);
	}

	public String remove(@PathVariable int id){
		return productDAO.deleteProduct(id);
	}

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

}
