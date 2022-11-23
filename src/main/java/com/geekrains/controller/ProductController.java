package com.geekrains.controller;

import com.geekrains.model.Customer;
import com.geekrains.model.Product;
import com.geekrains.repository.CustomerRepository;
import com.geekrains.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.geekrains.repository.ProductRepository;

import java.util.Arrays;
import java.util.Optional;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	ProductService productService;
/*
	@GetMapping("/check")
	@ResponseBody
	public String checkDB(){
		Customer customer1 = customerRepository.findById(1).get();
		Customer customer2 = customerRepository.findById(2).get();

		Product product1 = productRepository.findById(1).get();
		Product product2 = productRepository.findById(2).get();
		Product product3 = productRepository.findById(3).get();

		customer1.getBoughtProducts().add(product1);
		customer1.getBoughtProducts().add(product2);

		customer2.getBoughtProducts().add(product2);
		customer2.getBoughtProducts().add(product3);

		customerRepository.save(customer1);
		customerRepository.save(customer2);

		return "check";
	}

 */

	@GetMapping("/checkProductsOfCustomer{id}")
	@ResponseBody
	public String checkProductsOfCustomer(@PathVariable int id){
		return productService.findProductsOfCustomer(id);
	}

	@GetMapping("/checkCustomersOfProduct{id}")
	@ResponseBody
	public String checkCustomersOfProduct(@PathVariable int id){
		return productService.findCustomersOfProduct(id);
	}

/*
	@GetMapping("/seeAllProductsPage/{id}")
	@ResponseBody
	public Optional<Product> getProduct(@PathVariable int id) {
		return productRepository.findById(id);
	}

	@GetMapping("/seeAllProductsPage")
	public String showAllProducts(Model model){
		model.addAttribute("productsList",productRepository.findAll());
		return "seeAllProductsPage";
	}

	@GetMapping("/addProductPage")
	public String addProduct(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "addProductPage";
	}

	@PostMapping("/addProductPage")
	@ResponseBody
	public String submitForm(@ModelAttribute("product") Product product) {
		if (productRepository.findById(product.getId()).isPresent()){
			return "Failure";
		}
		productRepository.save(product);
		return product.toString() + " added sucessfully";
	}

 */
}
