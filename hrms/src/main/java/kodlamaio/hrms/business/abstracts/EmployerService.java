package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);
	Result delete(int id);
	DataResult<Optional<Employer>> get(int id);
	DataResult<List<Employer>> getAll();	
}