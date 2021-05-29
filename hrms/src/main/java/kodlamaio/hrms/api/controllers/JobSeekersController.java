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

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return this.jobSeekerService.add(jobSeeker);		
	}
	
	@DeleteMapping("{id}")
	public Result delete(@PathVariable int id) {
		return this.jobSeekerService.delete(id);
	}
	
	@GetMapping("{id}")
	public DataResult<Optional<JobSeeker>> get(@PathVariable int id){
		return jobSeekerService.get(id);
	}
	
	@GetMapping
	public DataResult<List<JobSeeker>> getAll()
	{
		return jobSeekerService.getAll();
	}
}
