package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	void add(JobSeeker jobSeeker);
	void delete(int id);
	Optional<JobSeeker> get(int id);
	List<JobSeeker> getAll();	
}