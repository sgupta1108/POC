package com.springboot.mindtree.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mindtree.model.OrderItem;
import com.springboot.mindtree.repo.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository repository;

	public void save( OrderItem order) {
		repository.save(order);
	}

	public List<OrderItem> getAll() {
		final List<OrderItem> orders = new ArrayList<>();
		repository.findAll().forEach(order -> orders.add(order));
		return orders;
	}
}
