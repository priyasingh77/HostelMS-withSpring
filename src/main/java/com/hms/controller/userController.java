package com.hms.controller;

import java.util.List;

import javax.validation.Valid;

import com.hms.dto.userDTO;
import com.hms.exception.globalException;
import com.hms.model.authRequest;
import com.hms.model.user;
import com.hms.serviceImpl.userServiceImpl;
import com.hms.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//class-level annotation
@RestController
@RequestMapping("/user")
public class userController {
	
	//creating dependency injection for service layer
	@Autowired
	private userServiceImpl service;
	
	
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtUtil jwt;
	
	@PostMapping("/authentication")
	public String generateToken(@RequestBody authRequest ar) {
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(ar.getUserName(),ar.getUserPassword()));
		return jwt.generateToken(ar.getUserName());
		
	}
	
	
	//Mapping Method ->1 To Add user in the DB
	@PostMapping("/add")
	public ResponseEntity<user> addUsers(@RequestBody @Valid userDTO u1){
		
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.ACCEPTED);
	}
	
	//Mapping Method ->2 To get list of  user from DB
	@GetMapping("/get")
	public ResponseEntity<List<user>> getUser(){
		List<user> userList=service.getUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
		
	}
	
	//Mapping Method ->3 To update the User Details in DB
	@PutMapping("/update")
	public ResponseEntity<user> updateUser(@RequestBody  @Valid userDTO u1){
		return new ResponseEntity<>(service.updateUser(u1),HttpStatus.ACCEPTED);
	}
	
	//Mapping Method ->4 To Delete  the user 
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable int userid) throws globalException{
		
		String status =service.deleteUser(userid);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//Mapping Method ->5 To update the user phone number 
	@PutMapping("/phone/{id}/{phone}")
	
	public ResponseEntity<String> updatePhone(@PathVariable int id ,@PathVariable String phone ) throws globalException{
		return new ResponseEntity<>(service.updatePhone(id, phone),HttpStatus.OK);
		
	}
	
	//Mapping Method ->6 Alloted a room to user 
	@PutMapping("/allotroom/{userid}/{roomid}")
	
	public ResponseEntity<String> allotRoom(@PathVariable int userid ,@PathVariable int roomid) throws globalException{
		return new ResponseEntity<>(service.allotRoom(userid, roomid),HttpStatus.OK);
		
	}
	
	//Mapping Method ->7 To update the user email
	@PutMapping("/update/{userid}/{email}")
	
	public ResponseEntity<String> updateEmail(@PathVariable int userid ,@PathVariable String  email) throws globalException{
		return new ResponseEntity<>(service.updateEmail(userid, email),HttpStatus.ACCEPTED);
		
	}
	
	//Mapping Method ->8 To update  the fees of an user 
	@PutMapping("/updatefee/{userid}/{userfee}")
	
	public ResponseEntity<String> updateFee(@PathVariable int userid ,@PathVariable int  userfee) throws globalException{
		return new ResponseEntity<>(service.updateFee(userid, userfee),HttpStatus.OK);
		
	}
	
	//Mapping Method ->9 To get the user details via userid
	@GetMapping("/get/id/{userid}")
	public ResponseEntity<user> getUserById(@PathVariable int userid) throws globalException{
		return new ResponseEntity<>(service.getUserById(userid),HttpStatus.ACCEPTED);
		
	}
	
		
	
}
