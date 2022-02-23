package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Amis;
import fr.solutec.entities.ClassMemo;
import fr.solutec.entities.User;
import fr.solutec.repository.AmisRepository;
import fr.solutec.repository.UserRepository;

@RestController @CrossOrigin("*")
public class AmisRest {
	@Autowired
	private AmisRepository amisRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	@PostMapping("amis/demande/{id}")
	public Amis requestAmisByUserId(@RequestBody User user,@PathVariable Long id){
		Optional<User> optu = userRepo.findById(id);
		Amis ami = new Amis(null,false,optu.get(),user);
		return amisRepo.save(ami);
	}

}
