package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@PostMapping("memo/user/{id}")
	public ClassMemo addMemoByUserId(@RequestBody ClassMemo memo,@PathVariable Long id){
		Optional<User> optu = userRepo.findById(id);
		memo.setDestinataire(optu.get());
		return classMemoRepo.save(memo);
	}
	@DeleteMapping("classmemo/delete/{id}")
	public boolean deleteOneClassMemoById(@PathVariable Long id){
		Optional<ClassMemo> memo = classMemoRepo.findById(id);
		if (memo.isPresent()) {
			classMemoRepo.deleteById(id);	
			return true;
		}else {
			return false;
		}
	}
}
