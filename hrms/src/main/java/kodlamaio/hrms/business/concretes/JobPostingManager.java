package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.business.constants.Messages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {	
		jobPostingDao.save(jobPosting);			
		return new SuccessResult(Messages.successfullyAdded);

	}

	@Override
	public Result delete(int id) {
		jobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi.");
	}

	@Override
	public DataResult<Optional<JobPosting>> get(int id) {
		return new SuccessDataResult<Optional<JobPosting>>(jobPostingDao.findById(id), "İş ilanı listelendi.");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll(), "İş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobPosting>> getByPosition(String position) {		
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByPosition(position));
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(jobPostingDao.getById(id));
	}

	@Override
	public DataResult<List<JobPosting>> getByActiveTrue() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByActiveTrue());
	}

	@Override
	public DataResult<List<JobPosting>> getByLastModifiedAndActiveTrue(LocalDate date) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByLastModifiedAndActiveTrue(date));
	}

	@Override
	public DataResult<JobPosting> updateJobPostingActiveStatusById(int id, boolean status) {
		JobPosting jobPosting = this.jobPostingDao.getById(id);
		jobPosting.setActive(status);
		this.jobPostingDao.save(jobPosting);
		
		return new SuccessDataResult<JobPosting>(jobPosting, "Status updated");
	}

	@Override
	public DataResult<List<JobPosting>> getByActiveTrueAndEmployer_Id(int id) {		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByActiveTrueAndEmployer_Id(id));
	}
}
