package com.springboot.mindtree.repo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.mindtree.model.OrderItemVO;

@FeignClient(name = "OrderItem", url = "http://localhost:10091")
public interface OrderItemClient {

	 @GetMapping("/order/item/save")
	 public int saveOrderItem(@RequestBody OrderItemVO item);
	 
}
