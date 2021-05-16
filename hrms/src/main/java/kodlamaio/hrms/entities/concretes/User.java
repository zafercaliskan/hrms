package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "password_hash")
	private String passwordHash;

	@Column(name = "password_salt")
	private String passwordSalt;

	@Column(name = "created_on")
	private LocalDate createdOn;

	@Column(name = "last_modified_on")
	private LocalDate lastModifiedOn;

	@Column(name = "is_activated")
	private boolean isActivated;
}