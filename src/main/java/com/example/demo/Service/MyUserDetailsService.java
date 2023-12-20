package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Implement.UserDetailsImplement;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
		User user = repo.findByUname(uname);
		if(user == null)
			throw new UsernameNotFoundException("User not Found");

		return new UserDetailsImplement(user);
	}
}
