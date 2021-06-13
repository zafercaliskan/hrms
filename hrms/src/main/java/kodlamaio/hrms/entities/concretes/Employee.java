package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "employees")

public class Employee extends User {
	@Column(name="identity_number", unique = true)
	private String identityNumber;
	
	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(name="gender", nullable = false)
	private String gender;
	
	@Column(name="date_of_birth", nullable = false)
	private LocalDate dateOfBirth;
}