package com.mvc.service;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mvc.model.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	private static final Logger logger = LoggerFactory.getLogger(CartService.class);


	@Autowired
	private CartRepository repo;
	@Autowired
	private UserRepository userRepository;


	@Autowired
	private ProductRepository productRepository;

	public List<Carts> listAll() {
		// TODO Auto-generated method stub

		logger.debug("Get All PRODUCT success!");

		return repo.findAll();

	}
	public Carts get(int id) {
		logger.debug("Get Cart By Id success!");

		return repo.findById(id).get();
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		logger.debug("Cart List successfully!");
		return productRepository.findAll();
	}
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		logger.debug("Cart List successfully!");
		return userRepository.findAll();

	}

	public void save(Carts carts) {
		// TODO Auto-generated method stub

		logger.debug("Cart Save successfully!");
		repo.save(carts);

	}

	public int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}


}