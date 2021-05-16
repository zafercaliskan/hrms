package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
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
	
	@PostMapping
	public void add(@RequestBody JobPosting jobPosting) {
		jobPostingService.add(jobPosting);		
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		jobPostingService.delete(id);
	}
	
	@GetMapping("{id}")
	public Optional<JobPosting> get(@PathVariable int id){
		return jobPostingService.get(id);
	}
	
	@GetMapping
	public List<JobPosting> getAll(){
		return jobPostingService.getAll();
	}
}