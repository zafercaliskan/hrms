package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosting;

@Repository
public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{

}
