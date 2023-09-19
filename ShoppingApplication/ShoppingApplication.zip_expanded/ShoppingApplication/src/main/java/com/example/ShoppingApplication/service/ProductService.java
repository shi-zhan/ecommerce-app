package com.example.ShoppingApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ShoppingApplication.domain.Product;
import com.example.ShoppingApplication.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> ListAll() {
		return repo.findAll();
	}
	
	public void save(Product product) {
		System.out.println("in save");
		System.out.println(product.getProductname());
		repo.save(product);
	}
	
	public Product get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}
