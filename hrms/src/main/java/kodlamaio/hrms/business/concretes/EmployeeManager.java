package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeDao) {
		super();
		this.employeDao = employeDao;
	}

	@Override
	public void add(Employee employee) {
		employeDao.save(employee);		
	}

	@Override
	public void delete(int id) {
		employeDao.deleteById(id);
	}

	@Override
	public Optional<Employee> get(int id) {
		return employeDao.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeDao.findAll();
	}

}
