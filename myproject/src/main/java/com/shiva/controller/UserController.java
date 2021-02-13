package com.shiva.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * This controller is created by Gopal for locusnine Microservice
 */

import org.springframework.web.bind.annotation.RestController;

import com.shiva.exceptions.UserAlreadyPresentException;
import com.shiva.exceptions.UserNotFoundException;
import com.shiva.model.User;
import com.shiva.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {
	
	private UserServiceImpl userServiceImpl;

	@Autowired
	public UserController(UserServiceImpl userServiceImpl) {
		super();
		this.userServiceImpl = userServiceImpl;
	}
	
	 /*
   This method will save restaurant data into the mysql database
    */
	
	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUserController(@RequestBody User user){
		User savedUser=null;
		try {
			savedUser=userServiceImpl.saveUser(user);
		} catch (UserAlreadyPresentException e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	 @GetMapping("/users")
	 public ResponseEntity<?> getAllUserController() {
	     return new ResponseEntity<List<User>>(userServiceImpl.getAllUsers(), HttpStatus.OK);
	 }
   
	 @DeleteMapping("/deleteuser/{id}")
	 public String deleteUserController(@PathVariable String id){
		 userServiceImpl.deleteUser(id);
		 return "User Deleted Successfully";
	 }
	 
	 @PutMapping("/edit/{id}")
	 public ResponseEntity<?> editUserController(@RequestBody User user, @PathVariable String id) throws UserNotFoundException{
		 user.setId(id);
		 return new ResponseEntity<User>(userServiceImpl.editUser(user), HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/user/{id}")
	 public ResponseEntity<?> getUser(@PathVariable String id){	 
		 Optional<User> getUserById = userServiceImpl.getUser(id);
	        return new ResponseEntity<User>(getUserById.get(), HttpStatus.OK);
		 
	 }
	
}
