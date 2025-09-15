package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Admin;

public interface IAdminService {
	public List<Admin>getAllAdmins();
	public Admin getAdminById(int id);
	public void updateAdminById(Admin admin ,int id);
	public void deleteAdminById(int id);
	public void addAdmin(Admin admin);
	public boolean validateAdminCredentials(String email,String password);
}
