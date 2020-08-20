package com.springboot.mindtree.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mindtree.model.OrderInfo;

@Repository
public interface OrderRepository extends CrudRepository<OrderInfo, Integer>{

}
