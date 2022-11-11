package com.hms.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class roomDTO {
	
	@NotNull(message ="room id cannot be null")
	private int roomId;
	@NotNull(message="room name cannot be null")
	private String roomName;
	@NotNull(message="room type cannot be null")
	private String roomType;
	
	

}
