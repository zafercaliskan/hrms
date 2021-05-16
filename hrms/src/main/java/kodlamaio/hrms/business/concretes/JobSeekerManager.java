package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public void add(JobSeeker jobSeeker) {
		jobSeekerDao.save(jobSeeker);		
	}

	@Override
	public void delete(int id) {
		jobSeekerDao.deleteById(id);
		
	}

	@Override
	public Optional<JobSeeker> get(int id) {		
		return jobSeekerDao.findById(id);
	}

	@Override
	public List<JobSeeker> getAll() {
		return jobSeekerDao.findAll();
	}
}