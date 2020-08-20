package com.springboot.mindtree.service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mindtree.model.OrderInfo;
import com.springboot.mindtree.model.OrderItemVO;
import com.springboot.mindtree.model.OrderVO;
import com.springboot.mindtree.repo.OrderItemClient;
import com.springboot.mindtree.repo.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repository;
	
	@Autowired
	OrderItemClient itemClient;

	public void save(OrderVO orderVo) {
		OrderInfo order = new OrderInfo();
		OrderItemVO item = new OrderItemVO();
		BeanUtils.copyProperties(orderVo, order);
		BeanUtils.copyProperties(orderVo, item);
		int itemId = itemClient.saveOrderItem(item);
		order.setCustomerName(orderVo.getCustomerName());
		order.setOrderItemId(itemId);
		order.setOrderDate(new Date(System.currentTimeMillis()));
		repository.save(order);
	}

	public List<OrderInfo> getAll() {
		final List<OrderInfo> orders = new ArrayList<>();
		repository.findAll().forEach(order -> orders.add(order));
		return orders;
	}
}
