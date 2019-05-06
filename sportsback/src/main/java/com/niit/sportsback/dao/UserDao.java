package com.niit.sportsback.dao;

import com.niit.sportsback.model.User;

public interface UserDao {
public boolean registerUser(User userdetail);
public boolean updateUser(User user);
public User getUser(String email);


}
