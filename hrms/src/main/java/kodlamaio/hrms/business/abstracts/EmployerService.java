package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	void add(Employer employer);
	void delete(int id);
	Optional<Employer> get(int id);
	List<Employer> getAll();	
}