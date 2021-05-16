package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeService {
	void add(Employee employee);
	void delete(int id);
	Optional<Employee> get(int id);
	List<Employee> getAll();
}