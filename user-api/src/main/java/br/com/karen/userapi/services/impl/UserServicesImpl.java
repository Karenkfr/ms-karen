package br.com.karen.userapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.karen.userapi.domain.User;
import br.com.karen.userapi.repositories.UserRepository;
import br.com.karen.userapi.services.UserServices;
import br.com.karen.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Long id) {
		return repository.findById(id)
				.orElseThrow(
						() -> 
						new ObjectNotFoundException("Object not found")
						);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}
}
