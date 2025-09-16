package com.oracle.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.dao.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
/*
 * This interface is auto-implemented by spring boot
 * The implementation object is available to use in the application
 * The implementation object performs CRUD operations on the User entity in-turn on user table
 */
