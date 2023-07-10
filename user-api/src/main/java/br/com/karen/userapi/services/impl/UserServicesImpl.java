package br.com.karen.userapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.karen.userapi.domain.User;
import br.com.karen.userapi.repositories.UserRepository;
import br.com.karen.userapi.services.UserServices;
import br.com.karen.userapi.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserRepository repository;
	private final Environment env;

	@Override
	public User findById(Long id) {
		log.info("USER_SERVICE :::  Get request on" +  env.getProperty("local.server.port" + "port"));
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
