package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class FakeMernisServiceAdapter implements VerificationService {

	@Override
	public boolean isItARealPerson(JobSeeker jobSeeker) {
		return true;
	}

}
