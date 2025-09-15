package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.User;

public interface IUserServices {
	public List<User> getAllUser();
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public String updateUser(User user,int id);
	public String deleteUser(int id);
	public String addUser(User user);
	public boolean validateLoginCredentials(String email,String password);
}
