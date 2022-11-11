package com.hms.repository;

import com.hms.model.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface roomRepository extends JpaRepository<room,Integer> {
	
	@Query(value="select* from  room where room_id=?1",nativeQuery=true)
	room findByRoomId(int roomid);
	
	
	
	
	

}
