package fr.solutec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	public List<Event> findByDateEvent(Date dateEvent);
	
	// JPQL
	@Query(value = "SELECT e FROM Event e WHERE e.dateEvent > ?1")
	public List<Event> getEventByDateAfter(Date dateEvent);
	
	public List<Event> findByDateEventAfter(Date dateEvent);
	public List<Event> findByDateEventBefore(Date dateEvent);
}
