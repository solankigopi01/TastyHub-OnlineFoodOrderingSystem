package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Product;

public interface IProductService {
	public Product addProduct(Product prod);
	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public String updateProductById(int id, Product prod);
	public String deleteProductById(int id);
	public Product getProductByName(String name);
}
