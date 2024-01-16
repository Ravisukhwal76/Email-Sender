package com.intechita.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intechita.entity.User;
import com.intechita.service.EmailService;
import com.intechita.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
	
	UserService userService;
	EmailService emailService;
	
	@PostMapping("/createUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
	   User user2 =	userService.saveUser(user);
		return new ResponseEntity<User>(user2,HttpStatus.CREATED);
	}
	
	@GetMapping("/hii")
	public String s() {
		return "hello";
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") long id){
		User getUser = userService.getUser(id);
		return new ResponseEntity<User>(getUser,HttpStatus.OK);
	}
	
	@GetMapping("/sendEmailUsingId/{id}")
	public ResponseEntity<String> sendEmail(@PathVariable("id") long id){
	   
		User getUser = userService.getUser(id);
	    String to  =getUser.getEmail();
	    String subject = "From Ravi !";
	    String text ="hii i am sending email from bmbb plese let me knoe you get it !";
	    emailService.sendEmail(to, subject, text);
	    
	    return new ResponseEntity<String>("Mail successfully sent it !",HttpStatus.OK); 
	}

}
