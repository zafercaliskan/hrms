package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeService {
	Result add(Employee employee);
	Result delete(int id);
	DataResult<Optional<Employee>> get(int id);
	DataResult<List<Employee>> getAll();
}