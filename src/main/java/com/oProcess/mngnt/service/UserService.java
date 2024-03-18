package com.oProcess.mngnt.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.oProcess.mngnt.dto.Userdto;

public interface UserService {

	List<Userdto> showUsers();

	Userdto saveUsers(Userdto userdto);

	Userdto showbyID(Userdto userdto, Long userId);

	public ResponseEntity<Userdto> updateUsers(@PathVariable Long userId, @RequestBody Userdto userdto);

	void dltUsers(@PathVariable Long userId);

}
