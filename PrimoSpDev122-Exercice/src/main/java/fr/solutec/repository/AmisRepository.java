package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Amis;
import fr.solutec.entities.User;

public interface AmisRepository extends CrudRepository<Amis, Long>{
	public Optional<Amis> findByU1(User u1);
	public Optional<Amis> findByU2(User u2);
}
