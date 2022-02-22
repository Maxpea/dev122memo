package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("user/connect/{login}/{password}")
	public Optional<User> getUserByLoginAndPassword(@PathVariable String login,@PathVariable String password){
		Optional<User> U = userRepo.findByLogin(login);
		String psw = U.get().getPassword();
		if (psw.equals(password)) {
			return U;
		}else {
			return null;
		}	
	}
	@GetMapping("memo/user/{id}")
	public String getMemoUserById(@PathVariable Long id){
		Optional<User> U = userRepo.findById(id);
		String memo = U.get().getMemo();
		return memo;
	}	
	@GetMapping("user")
	public Iterable<User> getAllUser(){
		return userRepo.findAll();
	}
	@GetMapping("user/memo")
	public List<String> getAllMemo(){
		Iterable<User> ItU = userRepo.findAll();
		List<String> ListeMemo = new ArrayList<>();
		for (User u : ItU) {
			ListeMemo.add(u.getMemo());
		}
		return ListeMemo;
		
	}
}
