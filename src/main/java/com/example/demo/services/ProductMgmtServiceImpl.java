package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service("product")
public class ProductMgmtServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product prod) {
		Product saveProd=productRepository.save(prod);
		return saveProd;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list=(List<Product>) productRepository.findAll();
		return list;
	}

	@Override
	public Product getProductById(int id) {
		Optional<Product> opt=productRepository.findById(id);
		Product product=opt.get();
		return product;
		
	}

	@Override
	public String updateProductById(int id,Product prod) {
		Optional<Product>opt=productRepository.findById(id);
		if(opt.isPresent()) {
			productRepository.save(prod);
			return "Product is updated";
		}
		else {
			return "This product does not exist";
		}
	}

	@Override
	public String deleteProductById(int id) {
		Optional<Product>opt=productRepository.findById(id);
		if(opt.isPresent()) {
			productRepository.deleteById(id);;
			return "Product is deleted";
		}
		else {
			return "This product does not exist";
		}
	}

	@Override
	public Product getProductByName(String name) {
		Product prod=productRepository.findByPname(name);
		if(prod !=null) {
			return prod;
		}
		return null;
	}

}
