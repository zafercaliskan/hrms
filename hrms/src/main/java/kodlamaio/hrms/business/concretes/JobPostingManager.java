package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
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
	public void add(JobPosting jobPosting) {
		jobPostingDao.save(jobPosting);
	}

	@Override
	public void delete(int id) {
		jobPostingDao.deleteById(id);
	}

	@Override
	public Optional<JobPosting> get(int id) {
		return jobPostingDao.findById(id);
	}

	@Override
	public List<JobPosting> getAll() {
		return jobPostingDao.findAll();
	}

}
