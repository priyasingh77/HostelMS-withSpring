package com.hms.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class room {
	@Id
	private int roomId;
	private String roomName;
	private String roomType;
	
	
	

}
