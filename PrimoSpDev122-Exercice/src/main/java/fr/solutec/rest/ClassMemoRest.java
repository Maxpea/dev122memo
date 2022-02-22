package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.ClassMemo;
import fr.solutec.entities.User;
import fr.solutec.repository.ClassMemoRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class ClassMemoRest {
	
	@Autowired
	private ClassMemoRepository classMemoRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("classMemo")
	public Iterable<ClassMemo> getAllClassMemo(){
		return classMemoRepo.findAll();
	}
	@PostMapping("memo/{text}/{id}")
	public User addMemoByIdUser(@RequestBody String text,@RequestBody Long id){
		Optional<User> optu = userRepo.findById(id);
		
		return optu.get();
	}
}