package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Orders;
import com.example.demo.entities.User;

public interface IOrderServices {
	public List<Orders> getAllOrders();
	public Orders saveOrder(Orders order);
	public String updateOrder(int id, Orders order);
	public String deleteOrder(int id);
	public List<Orders> getOrdersForUser(User user);
	
}
