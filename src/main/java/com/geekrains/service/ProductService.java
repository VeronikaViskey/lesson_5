package com.geekrains.service;

import com.geekrains.repository.CustomerRepository;
import com.geekrains.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;


    public String findProductsOfCustomer(int id){
        return customerRepository.findById(id).get().getBoughtProducts().toString();
    }

    public String findCustomersOfProduct(int id){
        return productRepository.findById(id).get().getProductCustomers().toString();
    }
}
