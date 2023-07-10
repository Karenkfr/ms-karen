package br.com.karen.userapi.services;

import java.util.List;

import br.com.karen.userapi.domain.User;

public interface UserServices {

	User findById(Long id);
	List<User>findAll();
}
