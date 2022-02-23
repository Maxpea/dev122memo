package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Amis {
	@Id @GeneratedValue
	private Long id;
	private boolean isFriend;
	@ManyToOne
	private User u1;
	@ManyToOne
	private User u2;
	
}
