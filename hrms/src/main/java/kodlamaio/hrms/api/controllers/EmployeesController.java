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

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Employee employee){
		employeeService.add(employee);		
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody int id) {
		employeeService.delete(id);
	}
	
	@GetMapping("/get")
	public Optional<Employee> get(@RequestBody int id) {
		return employeeService.get(id);		
	}
	
	@GetMapping("/getall")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}	
}