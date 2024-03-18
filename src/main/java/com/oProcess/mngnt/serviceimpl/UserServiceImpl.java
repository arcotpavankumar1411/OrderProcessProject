package com.oProcess.mngnt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oProcess.mngnt.dto.Userdto;
import com.oProcess.mngnt.exception.UserNotFoundException;
import com.oProcess.mngnt.reposiroty.UserRepository;
import com.oProcess.mngnt.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepository;

	@Override
	public List<Userdto> showUsers() {
		
		return userrepository.findAll();
	}

	@Override
	public Userdto saveUsers(Userdto userdto) {
		
		return userrepository.save(userdto);
	}

	@Override
	public Userdto showbyID(Userdto userdto, Long userId) {
		
		Userdto getUserById =userrepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("Product not found with id " + userId));
		
		
		return getUserById;
	}

	@Override
	public ResponseEntity<Userdto> updateUsers(Long userId, Userdto userdto) {
		
		Userdto updateUserById =userrepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("Product not found with id " + userId));
		
		updateUserById.setUserId(userdto.getUserId());
		updateUserById.setUserName(userdto.getUserName());
		updateUserById.setUserDetails(userdto.getUserDetails());
		
		userrepository.save(updateUserById);
		
		
		return ResponseEntity.ok(updateUserById);
	}

	@Override
	public void dltUsers(Long userId) {
		
		Userdto updateUserById =userrepository.findById(userId)
				.orElseThrow(() -> new UserNotFoundException("Product not found with id " + userId));
		
		userrepository.deleteById(userId);
		
	}

	
}
