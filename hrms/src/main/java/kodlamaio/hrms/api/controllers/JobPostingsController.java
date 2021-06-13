package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingsController {
	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingsController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping //add a job posting
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);		
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable int id) {
		return this.jobPostingService.delete(id);
	}
	
	@GetMapping("{id}") //get job posting
	public DataResult<Optional<JobPosting>> get(@PathVariable int id){
		return jobPostingService.get(id);
	}
	
	@GetMapping
	public DataResult<List<JobPosting>> getAll(){
		return jobPostingService.getAll();
	}
	
	@GetMapping("/getByPosition")
	public DataResult<List<JobPosting>> getByPosition(@RequestParam String position){
		return this.jobPostingService.getByPosition(position);

	}	
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobPosting>> getByIsActive(){
		return this.jobPostingService.getByActiveTrue();
	}
	
	@GetMapping("/getByActiveTrueAndEmployerId")
	public DataResult<List<JobPosting>> getByActiveTrueAndEmployerId(@RequestParam int id){
		return this.jobPostingService.getByActiveTrueAndEmployer_Id(id);
	}
	
	@GetMapping("/getByLastModifiedAndActive")
	public DataResult<List<JobPosting>> getByLastModifiedAndActive(@RequestParam LocalDate date){
		return this.jobPostingService.getByLastModifiedAndActiveTrue(date);
	}
	
	@PutMapping("/updateJobPostingActiveStatusById")
	public DataResult<JobPosting> updateJobPostingActiveStatusById(@Positive @RequestParam int id, @RequestParam boolean status)
	{
		return this.jobPostingService.updateJobPostingActiveStatusById(id, status);
	}
}