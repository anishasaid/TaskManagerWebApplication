package com.example.services.auth;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.SignupRequest;
import com.example.dto.UserDto;
import com.example.entities.User;
import com.example.enums.UserRole;
import com.example.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
	
	private final UserRepository userRepository;
	
	@PostConstruct
	public void createAnAdminAccount() {
		Optional<User>optionalUser =  userRepository.findByUserRole(UserRole.ADMIN);
		
		if(optionalUser.isEmpty()) {
			User user = new User();
			user.setEmail("admin@test.com");
			user.setName("admin");
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			user.setUserRole(UserRole.ADMIN);
			userRepository.save(user);
			System.out.println("Admin account created successfully!");
		}else {
			System.out.println("Admin account already exist!");
		}
	}

	@Override
	public UserDto signupUser(SignupRequest signupRequest) {
		User user = new User();
		user.setEmail(signupRequest.getEmail());
		user.setName(signupRequest.getName());
		user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
		user.setUserRole(UserRole.EMPLOYEE);
		User createUser= userRepository.save(user);
		
		return createUser.getUserDto();
	}

	@Override
	public boolean hasUserWithEmail(String email) {
		
		return userRepository.findFirstByEmail(email).isPresent();
	}

}















