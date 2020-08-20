package com.springboot.mindtree.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mindtree.model.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

}
