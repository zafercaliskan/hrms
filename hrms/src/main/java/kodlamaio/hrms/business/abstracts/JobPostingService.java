package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	void add(JobPosting jobPosting);
	void delete(int id);
	Optional<JobPosting> get(int id);
	List<JobPosting> getAll();
}
