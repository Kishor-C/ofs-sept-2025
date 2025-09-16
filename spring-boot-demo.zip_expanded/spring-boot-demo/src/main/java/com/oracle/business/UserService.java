package com.oracle.business;

import java.util.List;


import com.oracle.dao.entities.User;

public interface UserService {

	User createUser(User user);

	List<User> fetchUsers();

	User fetchUser(int id);

}