package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.User;
import fr.solutec.repository.UserRepository;



@RestController @CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("user/login/{login}")
	public Optional<User> getUserByLogin(@PathVariable String login){
		return userRepo.findByLogin(login);
	}
	
//	@PostMapping("user/connect")
//	public Optional<User> getUserByLoginAndPassword(@RequestBody String login,@RequestBody String password){
//		Optional<User> U = userRepo.findByLogin(login);
//		return userRepo.findByLoginAndPassword(U.getLogin(), U.getPassword());
//		String psw = U.get().getPassword();
//		if (psw.equals(password)) {
//			return U;
//		}else {
//			return null;
//		}
//	}
	
	@PostMapping("user/connect")
	public Optional<User> login(@RequestBody User p){
		return userRepo.findByLoginAndPassword(p.getLogin(), p.getPassword());
	}
	
	@GetMapping("user")
	public Iterable<User> getAllUser(){
		return userRepo.findAll();
	}
}
