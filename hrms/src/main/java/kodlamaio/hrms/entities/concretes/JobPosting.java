package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name="position", nullable = false)
	private String position;
	
	//İş tanımı
	@Column(name="job_description", nullable = false)
	private String jobDescription;
	
	@Column(name="city", nullable = false)
	private String city;	
	
	@Column(name="salary_min", nullable = true)
	private int salaryMin;
	
	@Column(name="salary_max", nullable = true)
	private int salaryMax;
	
	//Açık pozisyon
	@Column(name="mumber_of_open_position", nullable = false)
	private int numberOfOpenPosition;
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	//Son basvuru tarihi
	@Column(name="application_deadline", nullable = false)
	private LocalDate applicationDeadline;
	
	//Yayınlanma tarihi
	@Column(name="release_date", nullable = true)
	private LocalDate releaseDate;
	
	@Column(name="created_on", nullable = false)
	private LocalDate createdOn;
	
	@Column(name="last_modified", nullable = false)
	private LocalDate lastModified;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
}