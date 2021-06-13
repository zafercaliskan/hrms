package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.abstracts.EmailService;
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
	private EmailService emailService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(Employer employer) {

		if (!isCompanyEmail(employer.getEmail(), employer.getWebSite())) {
			return new ErrorResult(Messages.wrongMailFormat);
		} else if (!emailService.verifyTheVerificationCode(null)) {
			return new ErrorResult(Messages.notVerifyMail);
		} else if (!employer.isStatus()) {
			return new ErrorResult(Messages.weCanTVerifyYourAccount);
		} else {
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

		if (email == null || email.isEmpty()) {
			return false;
		} else {
			String[] array = webSite.split("www.");

			String finalString = array[1];

			String emailRegex = "info@" + finalString;
			Pattern pattern = Pattern.compile(emailRegex);

			return pattern.matcher(email).matches();
		}
	}
}