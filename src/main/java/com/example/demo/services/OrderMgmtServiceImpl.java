package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Orders;
import com.example.demo.entities.User;
import com.example.demo.repositories.OrderRepository;

@Service("orders")
public class OrderMgmtServiceImpl implements IOrderServices {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<Orders> getAllOrders() {
		List<Orders> list=orderRepository.findAll();
		return list;
	}

	@Override
	public Orders saveOrder(Orders order) {
		Orders newOrder=orderRepository.save(order);
		return newOrder;
	}

	@Override
	public String updateOrder(int id, Orders order) {
		Optional<Orders> opt=orderRepository.findById(id);
		if(opt.isEmpty()) {
			return "This order is not present.";
		}
		else {
			orderRepository.save(order);
			return "Order is updated";
		}
	}

	@Override
	public String deleteOrder(int id) {
		Optional<Orders> opt=orderRepository.findById(id);
		if(opt.isEmpty()) {
			return "This order is not present.";
		}
		else {
			orderRepository.deleteById(id);
			return "Order is deleted";
		}
	}

	@Override
	public List<Orders> getOrdersForUser(User user) {
		return  this.orderRepository.findOrdersByUser(user);
	}

}
