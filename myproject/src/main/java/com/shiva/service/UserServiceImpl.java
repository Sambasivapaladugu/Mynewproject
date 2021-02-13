package com.shiva.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.exceptions.UserAlreadyPresentException;
import com.shiva.exceptions.UserNotFoundException;
import com.shiva.model.User;
import com.shiva.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
    @Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
    
    

	
	public UserServiceImpl() {
		super();
	}




	@Override
	public User saveUser(User user) throws UserAlreadyPresentException {
		User newUser;
		if(userRepository.existsById(user.getId())) {
			throw new UserAlreadyPresentException("User Already Present");
		}
		else {
			newUser= (User) userRepository.save(user);
		}
		return newUser;
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User editUser(User user) throws UserNotFoundException {
		User newUser;
		if(!userRepository.existsById(user.getId())) {
			throw new UserNotFoundException("User not found");
		}
		else {
			newUser= (User) userRepository.save(user);
		}
		return newUser;
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteById(id);		
	}
	
	@Override
	public Optional<User> getUser(String id) {
		Optional<User> newUser= userRepository.findById(id);
		return newUser;
	}

}
