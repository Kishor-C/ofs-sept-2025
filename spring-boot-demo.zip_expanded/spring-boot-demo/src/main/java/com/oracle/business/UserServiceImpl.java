package com.oracle.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.dao.UserRepository;
import com.oracle.dao.entities.User;

@Service
public class UserServiceImpl implements UserService {

	/*
	 * Autowire the UserRepository
	 * implement CRUD operations that calls methods present in the UserRepository
	 * some of the methods of UserRepository inherited from JpaRepository are: save(T), findAll(), findById(ID)
	 */
	@Autowired
	private UserRepository userDao;
	
	@Override
	@Transactional // used when you perform DDL operations - insert, update, delete
	public User createUser(User user) { // in real-time you don't directly expose entities to the controller - dto
		return userDao.save(user);
	}
	@Override
	public List<User> fetchUsers() {
		return userDao.findAll();
	}
	
	@Override
	public User fetchUser(int id) {
		Optional<User> option = userDao.findById(id);
		return option.orElseThrow(()->new RuntimeException("User with an id "+id+" not found"));
	}
}
