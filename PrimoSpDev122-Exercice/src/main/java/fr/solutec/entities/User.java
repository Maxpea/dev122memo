package fr.solutec.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class User {
	@Id @GeneratedValue
	private Long id;
    @Column(unique=true)
	private String login;
    @Column(unique=true)
	private String password;
    private String memo;
	
}
