package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.repositories.AdminRepository;

@Service("admin")
public class AdminMgmtServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Admin> getAllAdmins() {
		 List<Admin> admins = (List<Admin>)this.adminRepository.findAll();
		 return admins;
	}

	@Override
	public Admin getAdminById(int id) {
		Optional<Admin> optional = this.adminRepository.findById(id);
		Admin admin=optional.get();
		return admin;
	}

	@Override
	public void updateAdminById(Admin admin, int id) {
		for (Admin ad : getAllAdmins()) 
		{
			if(ad.getAdminId()==id)
			{
				this.adminRepository.save(admin);
			}
		}
	}

	@Override
	public void deleteAdminById(int id) {
		this.adminRepository.deleteById(id);

	}

	@Override
	public void addAdmin(Admin admin) {
		this.adminRepository.save(admin);

	}

	@Override
	public boolean validateAdminCredentials(String email, String password) {
		Admin admin=adminRepository.findByAdminEmail(email);
		if(admin!=null && admin.getAdminPassword().equals(password))
		{
			return true;
		}
		return false;
	}

}
