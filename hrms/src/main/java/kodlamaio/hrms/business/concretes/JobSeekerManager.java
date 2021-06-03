package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.abstracts.EmailService;
import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.StringExtensions;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private VerificationService verificationService;
	private EmailService emailService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, VerificationService verificationService, EmailService emailService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.verificationService = verificationService;
		this.emailService = emailService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if (StringExtensions.isNullOrEmpty(jobSeeker.getEmail(), jobSeeker.getFirstName(), jobSeeker.getLastName(),
				jobSeeker.getIdentityNumber(), jobSeeker.getPasswordHash(), jobSeeker.getPasswordSalt(),
				String.valueOf(jobSeeker.getDateOfBirth().getYear()))) {
			return new ErrorResult(Messages.requiredFields);

		} else if (!verificationService.isItARealPerson(jobSeeker)) {
			return new ErrorResult(Messages.notExistGovernment);
		}

		else if (this.jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null
				|| this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()) != null) {
			return new ErrorResult(Messages.existInSystem);
		}

		else if(!emailService.verifyTheVerificationCode(null)) {
			return new ErrorResult(Messages.notVerifyMail);
		}
		else {
			jobSeekerDao.save(jobSeeker);
			return new SuccessResult(Messages.successfullyAdded);
		}
	}

	@Override
	public Result delete(int id) {
		jobSeekerDao.deleteById(id);
		return new SuccessResult("İş arayan silindi.");

	}

	@Override
	public DataResult<Optional<JobSeeker>> get(int id) {
		return new SuccessDataResult<Optional<JobSeeker>>(jobSeekerDao.findById(id), "İş arayan listelendi.");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "İş arayanlar listelendi.");
	}
}