package com.springboot.mindtree.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mindtree.model.OrderInfo;
import com.springboot.mindtree.model.OrderVO;
import com.springboot.mindtree.service.OrderService;

@RestController
public class OrderController {

	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

	@Autowired
	OrderService service;

	@PostMapping(value= "/order/save")
	public String save(@RequestBody  OrderVO order) {
		log.info("Saving Order details in the database.");
		String res = "Saved Successfully";
		if(null != order && StringUtils.isNotEmpty(order.getCustomerName())) {
			service.save(order);
		}else {
			res = "Invalid Input request";
		}
		return res;
	}

	@GetMapping(value= "/order/getall")
	public List<OrderInfo> getAll() {
		log.info("Getting Order details from the database.");
		return service.getAll();
	}
}
