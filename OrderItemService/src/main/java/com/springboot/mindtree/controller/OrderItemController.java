package com.springboot.mindtree.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mindtree.model.OrderItem;
import com.springboot.mindtree.service.OrderItemService;

@RestController
public class OrderItemController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	OrderItemService service;

	@PostMapping(value= "/order/item/save")
	public int save(@RequestBody  OrderItem order) {
		log.info("Saving Order Item details in the database.");
		service.save(order);
		return order.getOrderItemId();
	}

	@GetMapping(value= "/order/item/getall")
	public List<OrderItem> getAll() {
		log.info("Getting Order Item details from the database.");
		return service.getAll();
	}
}
