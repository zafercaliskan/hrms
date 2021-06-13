package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosting;

@Repository
public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{		
	JobPosting getById(int id);
	List<JobPosting> getByPosition(String position);
	List<JobPosting> getByActiveTrue();
	List<JobPosting> getByLastModifiedAndActiveTrue(LocalDate date);	
	List<JobPosting> getByActiveTrueAndEmployer_Id(int employerId);
}