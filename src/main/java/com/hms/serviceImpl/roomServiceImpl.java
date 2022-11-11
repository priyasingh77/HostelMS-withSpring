package com.hms.serviceImpl;

import java.util.List;

import com.hms.dto.roomDTO;
import com.hms.exception.globalException;
import com.hms.model.room;
import com.hms.repository.roomRepository;
import com.hms.service.roomService;
import com.hms.util.valueMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class roomServiceImpl  implements roomService{
	
	@Autowired
	 private roomRepository roomrepo;
	
	// Method to add room in DataBase
	public room addRoom(roomDTO r1) {
		room r2=valueMapper.convertoRoom(r1);
		return roomrepo.save(r2);
	}
	
	//Method to retrive List of room from DataBase 
	public List<room> getRoom(){
		return roomrepo.findAll();
	}
	
	//Method to update room 
	public room updateRoom(roomDTO r1) {
		room r2= valueMapper.convertoRoom(r1);
		return roomrepo.save(r2);
	}
	
	// Method to deleteRoom 
	public String deleteRoom(int roomid) throws globalException {
		room r2=roomrepo.findByRoomId(roomid);
		if(r2!=null) {
			roomrepo.deleteById(roomid);
			return "Room is Deleted";
		}
		else {
			throw new globalException("Room NOtFound !!");
		}
	}
	

}
