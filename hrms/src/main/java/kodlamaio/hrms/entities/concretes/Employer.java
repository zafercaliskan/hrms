package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "employer_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPostings"})
@Inheritance(strategy = InheritanceType.JOINED)
public class Employer extends User{
	
	
	@NotNull(message = "Company name cannot be empty")
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_site", nullable = false)
	private String webSite;
	
	@Column(name="status", nullable = false)
	private boolean status;
	
	@OneToMany(mappedBy = "employer")
    private List<JobPosting> jobPostings;
}