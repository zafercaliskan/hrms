package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.JobSeeker;

public interface VerificationService {
	boolean isItARealPerson(JobSeeker jobSeeker);
}