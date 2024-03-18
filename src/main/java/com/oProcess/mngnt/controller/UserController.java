package com.oProcess.mngnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oProcess.mngnt.dto.Userdto;
import com.oProcess.mngnt.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/showusers")
	private List <Userdto> showallUsers(){
		return userservice.showUsers();
		
	}
	
	@GetMapping("/showbyid/{userId}")
	Userdto showUserById(Userdto userdto,@PathVariable Long userId) {
		return userservice.showbyID(userdto, userId);
		
	}
	
	@PostMapping("/saveorrders")
	private Userdto enterNewUser(@Valid @RequestBody Userdto userdto) {
		return userservice.saveUsers(userdto);
		
	}
	
	@PutMapping("/Updatebyid/{userId}")
	ResponseEntity<String> updateUser(@PathVariable Long userId,@RequestBody Userdto userdto){
		userservice.updateUsers(userId, userdto);
		
		return ResponseEntity.ok("Updated successfully");
		}
	
	@DeleteMapping("/dltbyid/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		userservice.dltUsers(userId);
		return ResponseEntity.ok("deleted  successfully");
		
	}

}
