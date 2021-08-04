package com.israelspring.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.israelspring.mongo.domain.User;
import com.israelspring.mongo.dto.UserDTO;
import com.israelspring.mongo.repository.UserRepository;
import com.israelspring.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			User newUser = user.get();
			return newUser;
		}else {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getName());
	}
}
