package com.example.services.auth;

import com.example.dto.SignupRequest;
import com.example.dto.UserDto;

public interface AuthService {

	UserDto signupUser(SignupRequest signupRequest);
	
	boolean hasUserWithEmail(String email);
}
