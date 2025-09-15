package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.User;
import com.example.demo.services.UserMgmtServiceImpl;

@Controller
public class UserController
{
	@Autowired
	private UserMgmtServiceImpl services;

	@PostMapping("/addingUser")
	public String  addUser(@ModelAttribute User user)
	{
		System.out.println(user);
		this.services.addUser(user);
		return "redirect:/admin/services";
	}

	@GetMapping("/updatingUser/{id}")
	public String updateUser(@ModelAttribute User user, @PathVariable int id)
	{
		this.services.updateUser(user, id);
		return "redirect:/admin/services";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		this.services.deleteUser(id);
		return "redirect:/admin/services";
	}
	

	@GetMapping("/register")
	public String registerUserShowForm(@ModelAttribute("userRegistration") User user) {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerNewUser(@ModelAttribute("userRegistration") User user, RedirectAttributes attrs) {
		String msg=services.addUser(user);
		attrs.addFlashAttribute("resultMsg", msg);
		return "redirect:/login";
	}

}
