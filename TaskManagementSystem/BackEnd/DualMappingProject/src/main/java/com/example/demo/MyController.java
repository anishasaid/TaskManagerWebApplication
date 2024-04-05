package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
	TaskRepo taskRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@RequestMapping("add{id}")
	public Task add(@PathVariable int id, @RequestBody String details) 
	{
		try {
			User user=userRepo.findById(id).get();
			Task task = new Task();
			task.setDetails(details);
			task.setUser(user);
			
			Task dbTask = taskRepo.save(task);
			
			
			return dbTask;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("delete{id}")
	public boolean delete(@PathVariable int id) {
		try {
			taskRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@RequestMapping("readAllTasks{id}")
	public List<Task> readAllTask(@PathVariable int id){
		
		try {
			
			return taskRepo.findByUserId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("login")
	public int login(@RequestBody String[] sa) {
		try {
		String uiusername=sa[0];
		String uipassword=sa[1];
		
		if(userRepo.countByUsername(uiusername) != 1)
			return 0;
		
		User user = userRepo.findByUsername(uiusername);
		
		if(uipassword.equals(user.password)) {
			return user.id;
		}else {
			return 0;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}

}
