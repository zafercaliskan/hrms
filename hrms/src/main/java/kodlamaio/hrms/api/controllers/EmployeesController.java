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

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody Employee employee){
		return this.employeeService.add(employee);			
	}
	
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.employeeService.delete(id);
	}
	
	@GetMapping("/get/{id}")
	public DataResult<Optional<Employee>> get(@PathVariable int id) {
		return employeeService.get(id);		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll(){
		return employeeService.getAll();
	}	
}