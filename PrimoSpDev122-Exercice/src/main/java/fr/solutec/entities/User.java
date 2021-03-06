package fr.solutec.entities;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class User {
	@Id @GeneratedValue
	private Long id;
    @Column(unique=true, nullable = false)
	private String login;
    @Column(nullable=false)
	private String password;
    
}
