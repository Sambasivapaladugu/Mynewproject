package com.shiva.service;

import java.util.List;
import java.util.Optional;

import com.shiva.exceptions.UserAlreadyPresentException;
import com.shiva.exceptions.UserNotFoundException;
import com.shiva.model.User;

public interface UserService {

	public User saveUser(User user) throws UserAlreadyPresentException;
    public List<User> getAllUsers();
    public User editUser(User user) throws UserNotFoundException;
    public void deleteUser(String id);
    public Optional <User> getUser(String id);
}
