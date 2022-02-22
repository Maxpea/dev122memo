package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.ClassMemo;
import fr.solutec.entities.Event;
import fr.solutec.entities.User;
import fr.solutec.repository.ClassMemoRepository;
import fr.solutec.repository.EventRepository;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class PrimoSpDev122ExerciceApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ClassMemoRepository classMemoRepo;
	
	@Autowired
	private EventRepository eventRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PrimoSpDev122ExerciceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("**************************** Début lancement ****************************");
		
		User u1 = new User(null, "jo", "jojo");
		userRepo.save(u1);
		
		User u2 = new User(null, "ja", "jaja");
		userRepo.save(u2);
		
		User u3 = new User(null, "ji", "jiji");
		userRepo.save(u3);
		
		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		eventRepo.save(new Event(null, "bonjour", "Lorem ipsul dem consaolas blablabla", d.parse("14/07/2023")));
		eventRepo.save(new Event(null, "bonjour", "Lorem ipsul dem consaolas blablabla", d.parse("14/07/2018")));
		
		classMemoRepo.save(new ClassMemo(null, "jojo test memo",u1,u2));
		classMemoRepo.save(new ClassMemo(null, "jaja test memo",u2,u3));
		classMemoRepo.save(new ClassMemo(null, "jiji test memo",u3,null));
	}

}
