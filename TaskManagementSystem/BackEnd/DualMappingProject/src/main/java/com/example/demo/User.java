package com.example.demo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity @Getter@Setter
@Data
public class User {
	
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String username;
	String password;
	
	@OneToMany(fetch = FetchType.EAGER)
	List<Task> task;

	

	
	

}
