package com.example.dto;

import com.example.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	
	private String name;
	
	private String emil;
	
	private String password;
	
	private UserRole userRole;
}
