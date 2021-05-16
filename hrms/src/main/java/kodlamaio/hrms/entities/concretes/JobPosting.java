package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "job_postings")
public class JobPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="position")
	private String position;
	
	@Column(name="description")
	private String description;
	
	@Column(name="job_type")
	private String jobType;
	
	@Column(name="created_on")
	private LocalDate createdOn;
	
	@Column(name="last_modified_on")
	private LocalDate lastModifiedOn;
}