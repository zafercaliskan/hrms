package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.StringExtensions;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
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
	public Result add(Employer employer) {
		if (!StringExtensions.isNullOrEmpty(employer.getEmail(), employer.getWebSite(), employer.getEmail(),
				employer.getPasswordHash(), employer.getCompanyName())) {
			return new ErrorResult(Messages.requiredFields);
		} else if (!isCompanyEmail(employer.getEmail(), employer.getWebSite())) {
			return new ErrorResult(Messages.wrongMailFormat);
		} else if (this.employerDao.findByEmail(employer.getEmail()) != null) {
			return new ErrorResult(Messages.existInSystem);
		} 
		}
		else {
			this.employerDao.save(employer);
			return new SuccessResult(Messages.successfullyAdded);
		}
	}

	@Override
	public Result delete(int id) {
		employerDao.deleteById(id);
		return new SuccessResult("İşveren silindi.");
	}

	@Override
	public DataResult<Optional<Employer>> get(int id) {
		return new SuccessDataResult<Optional<Employer>>(employerDao.findById(id), "İşveren listelendi.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "İşverenler listelendi.");
	}

	private boolean isCompanyEmail(String email, String webSite) {

		if (email == null || email.isEmpty())
			return false;

		String[] array = webSite.split(".");

		String finalString = "";

		for (int i = 1; i < array.length; i++) {
			finalString += array[i];
		}

		String emailRegex = "info@" + finalString;
		Pattern pattern = Pattern.compile(emailRegex);

		return pattern.matcher(email).matches();
	}
}