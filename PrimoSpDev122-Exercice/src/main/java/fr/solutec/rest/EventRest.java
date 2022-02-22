package fr.solutec.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Event;
import fr.solutec.repository.EventRepository;

@RestController @CrossOrigin("*")
public class EventRest {
	
	@Autowired
	private EventRepository EventRepo;
	
	@PostMapping("event/create")
	public Event createEvent(@RequestBody Event event){
		return EventRepo.save(event);
	}
	
	@GetMapping("event/after")
	public List<Event> getEventByDateAfter(){
		Date d = new Date();
		return EventRepo.findByDateEventAfter(d);
	}
	
	@GetMapping("event/before")
	public List<Event> getEventByDateBefore(){
		Date d = new Date();
		return EventRepo.findByDateEventBefore(d);
	}

}
