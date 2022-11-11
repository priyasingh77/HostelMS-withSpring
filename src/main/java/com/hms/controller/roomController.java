package com.hms.controller;

import java.util.List;

import javax.validation.Valid;

import com.hms.dto.roomDTO;
import com.hms.exception.globalException;
import com.hms.model.room;
import com.hms.serviceImpl.roomServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//classlevel Mapping 
@RequestMapping("/room")
public class roomController {
	
	
	//create dependency injection 
	@Autowired
	private roomServiceImpl service;
	
	// Method to add room in Database
	@PostMapping("/add")
	public ResponseEntity<room> addRoom(@RequestBody @Valid   roomDTO r1){
		return new ResponseEntity<>(service.addRoom(r1),HttpStatus.ACCEPTED);
	}
	
	// Method to retrive list of room 
	@GetMapping("/get")
	public ResponseEntity<List<room>> getRooms(){
		return new ResponseEntity<>(service.getRoom(),HttpStatus.OK);
	}
	
	//Method to update room 
	@PutMapping("/update")
	public ResponseEntity<room> updateRoom(@RequestBody @Valid roomDTO r1){
		return new ResponseEntity<>(service.addRoom(r1),HttpStatus.ACCEPTED);
	}
	
	// Method to delete room via roomid 
	@DeleteMapping("/delete/{roomid}")
	public ResponseEntity<String> deleteRoom(@PathVariable int roomid ) throws globalException{
		
		String st= service.deleteRoom(roomid);
		if (st!=null) {
			return new ResponseEntity<>(st,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(st,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
