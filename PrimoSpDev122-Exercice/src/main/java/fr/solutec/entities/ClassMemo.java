package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class ClassMemo {
	@Id @GeneratedValue
	private Long id;
	private String text;
	@ManyToOne
	private User expeditaire;
	@ManyToOne
	private User destinataire;
}
