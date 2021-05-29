package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
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
	public Result add(Employee employee) {
		employeDao.save(employee);	
		return new SuccessResult("Çalışan eklendi.");
	}

	@Override
	public Result delete(int id) {
		employeDao.deleteById(id);
		return new SuccessResult("Çalışan silindi.");
	}

	@Override
	public DataResult<Optional<Employee>> get(int id) {
		return new SuccessDataResult<Optional<Employee>>(employeDao.findById(id), "Çalışan listelendi.");
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		
		return new SuccessDataResult<List<Employee>>(employeDao.findAll(), "Çalışanlar listelendi."); 
	}
}