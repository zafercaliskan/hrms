package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.EmailService;

public class FakeEmailManager implements EmailService {

	@Override
	public boolean verifyTheVerificationCode(String verificationCode) {
		return true; //simulation
	}

	@Override
	public void sendVerificationMail(String email, String content) {
		//simulation		
	}
}