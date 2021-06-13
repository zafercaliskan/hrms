package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result delete(int id);
	DataResult<Optional<JobPosting>> get(int id);
	DataResult<List<JobPosting>> getAll();	
	DataResult<JobPosting> getById(int id);
	DataResult<List<JobPosting>> getByPosition(String position);	
	DataResult<List<JobPosting>> getByActiveTrue();
	DataResult<List<JobPosting>> getByLastModifiedAndActiveTrue(LocalDate date);	
	DataResult<JobPosting> updateJobPostingActiveStatusById(int id, boolean status);
	DataResult<List<JobPosting>> getByActiveTrueAndEmployer_Id(int id);
}