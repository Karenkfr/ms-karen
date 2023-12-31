package br.com.karen.userapi.resources.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.karen.userapi.domain.User;
import br.com.karen.userapi.resources.UserResources;
import br.com.karen.userapi.services.UserServices;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class UserResoucesImpl implements UserResources{
	
	private final UserServices userServices;

	@Override
	public ResponseEntity<User> findById(Long id) {
		return ResponseEntity.ok().body(userServices.findById(id));
	}

	@Override
	public ResponseEntity<List<User>> findAll() {
		return ResponseEntity.ok().body(userServices.findAll());
	}

}
