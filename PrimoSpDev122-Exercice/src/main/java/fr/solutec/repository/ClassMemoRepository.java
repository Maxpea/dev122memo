package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.ClassMemo;
import fr.solutec.entities.User;


public interface ClassMemoRepository  extends CrudRepository<ClassMemo, Long>{
	public Optional<User> findByExpeditaire(User user);
	public Optional<User> findByDestinataire(User user);


}
