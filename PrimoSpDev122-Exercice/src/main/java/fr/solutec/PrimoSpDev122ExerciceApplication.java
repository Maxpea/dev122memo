package fr.solutec;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.ClassMemo;
import fr.solutec.entities.User;
import fr.solutec.repository.ClassMemoRepository;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class PrimoSpDev122ExerciceApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ClassMemoRepository classMemoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimoSpDev122ExerciceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**************************** Début lancement ****************************");
		userRepo.save(new User(null, "jo", "jojo","jojo test memo"));
		userRepo.save(new User(null, "ja", "jaja","jaja test memo"));
		userRepo.save(new User(null, "ji", "jiji","jiji test memo"));
		
		Optional<User> jo = userRepo.findById((long) 1);
		Optional<User> ja = userRepo.findById((long) 2);
		Optional<User> ji = userRepo.findById((long) 3);
		
		classMemoRepo.save(new ClassMemo(null, "jojo test memo",jo.get()));
		classMemoRepo.save(new ClassMemo(null, "jaja test memo",ja.get()));
		classMemoRepo.save(new ClassMemo(null, "jiji test memo",ji.get()));
	}

}
