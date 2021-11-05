package com.jee.dao;

import com.jee.model.User;

public interface UserDao {

	User login(String email, String password);

}
