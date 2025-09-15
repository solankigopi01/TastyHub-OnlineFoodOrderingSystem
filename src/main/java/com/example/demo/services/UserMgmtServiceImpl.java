package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service("user")
public class UserMgmtServiceImpl implements IUserServices {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		List<User> list=(List<User>) userRepository.findAll();
		return list;
	}

	@Override
	public User getUserById(int id) {
		Optional<User>opt=userRepository.findById(id);
		User user=opt.get();
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user=userRepository.findUserByUemail(email);
		return user;
	}

	@Override
	public String updateUser(User user, int id) {
		Optional<User> opt=userRepository.findById(id);
		if(opt.isEmpty()) {
			return "This user does not exist.";
		}else {
			userRepository.save(user);
			return "User is updated.";
		}

	}

	@Override
	public String deleteUser(int id) {
		Optional<User> opt=userRepository.findById(id);
		if(opt.isEmpty()) {
			return "This user is not exist.";
		}
		else {
			userRepository.deleteById(id);
			return "User is deleted.";
		}

	}

	@Override
	public String addUser(User user) {
		userRepository.save(user);
		return "user is added";

	}

	@Override
	public boolean validateLoginCredentials(String email, String password) {
		List<User> users = (List<User>) this.userRepository.findAll();
		for(User u:users)
		{
		if(u!=null && u.getUpassword().equals(password) && u.getUemail().equals(email))
		{
			return true;
		}
		}
		return false;
	}

}
