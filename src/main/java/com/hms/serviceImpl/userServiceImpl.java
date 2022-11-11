package com.hms.serviceImpl;

import java.util.List;

import com.hms.dto.userDTO;
import com.hms.exception.globalException;
import com.hms.model.user;
import com.hms.repository.userRepository;
import com.hms.service.userService;
import com.hms.util.valueMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
	
	//creating dependency injection for repository
	@Autowired
	private userRepository userrepo;
	
	//Add user In Database 
	public user addUser(userDTO u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);
		
	}
	
	//retriving users from Database
	public List<user> getUser(){
		return userrepo.findAll();
	}
	
	// Update User In Database 
	public user updateUser(userDTO u1) {
		user u2=valueMapper.convertoUser(u1);
		return userrepo.save(u2);	
	}
	
	//Delete User from Database
	public String deleteUser(int userid) throws globalException {
		user u2= userrepo.findByUserId(userid);
		if (u2!=null) {
			userrepo.deleteById(userid);
			return "user deleted";
		}
		else {
			throw new globalException("user not found");
			
		}
	}
	
	//Update user Phone number
	@Override
	public String updatePhone(int userid, String phone) throws globalException {
		int st=userrepo.updatePhone(userid, phone);
		
		if(st==1) {
			return "phone Number is updated!...";
		}
		else {
			throw new globalException("something went wrong ");
		}
	}
	
	//Allot a room to user
	@Override
	public String allotRoom(int userid, int roomid) throws globalException {
		int st=userrepo.allotRoom(userid,roomid);
		
		if(st==1) {
			return "Room Alloted to "+userid;
		}
		else {
			throw new globalException("something went wrong");
		}
	}
	
	
	// Update the UserFee
	@Override
	public String updateFee(int userid, int userfee) throws globalException {
		int st=userrepo.updateFee(userid,userfee);
		
		if(st==1) {
			return "Fee Update to "+userid;
		}
		else {
			throw new globalException("something went wrong ");
		}
	}
	
	
	// update the email of an user
	@Override
	public String updateEmail(int userid, String email) throws globalException {
		 user u2= userrepo.findByUserId(userid);
		 if(u2!=null) {
			 int st = userrepo.updateEmail(userid,email);
			 	return "Email Updated";
		 }
		 else {
			 throw new globalException("User Not found!..");
		 }	  
	}
	
	//Get the UserDetails via userid
	@Override
	public user getUserById(int userid) throws globalException {
		user u2=userrepo.findByUserId(userid);
		
		if(u2!=null) {
			return u2;
		}
		else {
			throw new globalException("user Not Found!....");
		}
	}
	
	
	
	
	
	
}
