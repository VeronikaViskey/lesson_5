package com.geekrains.controller;

import com.geekrains.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.geekrains.repository.ProductRepository;

import java.util.Optional;

@Controller
public class ProductController {

	@Autowired
	ProductRepository productRepository;

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
		if (productRepository.findById(product.getId()) == null
				|| !(product.getTitle() instanceof String)
				|| !(product.getCost() instanceof Double)){
			return "Failure";
		}
		productRepository.save(product);
		return product.toString() + " added sucessfully";
	}
}
