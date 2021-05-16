package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public void add(Employer employer) {
		employerDao.save(employer);
	}

	@Override
	public void delete(int id) {
		employerDao.deleteById(id);
	}

	@Override
	public Optional<Employer> get(int id) {
		return employerDao.findById(id);
	}

	@Override
	public List<Employer> getAll() {	
		return employerDao.findAll();
	}
}