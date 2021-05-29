package kodlamaio.hrms.business.concretes;

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
		if (this.jobPostingDao.findByPosition(jobPosting.getPosition()) != null) {
			return new ErrorResult(Messages.existInRecords);
		} else {
			jobPostingDao.save(jobPosting);
			return new ErrorResult(Messages.existInRecords);
		}
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
}