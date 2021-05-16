package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Employer employer)
	{
		employerService.add(employer);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody int id) {
		employerService.delete(id);
	}
	
	@GetMapping("/get")
	public Optional<Employer> get(@RequestBody int id){
		return employerService.get(id);
	}
	
	@GetMapping("/getall")
	public List<Employer> getAll()
	{
		return employerService.getAll();
	}
}