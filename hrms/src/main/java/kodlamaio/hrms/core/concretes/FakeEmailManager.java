package kodlamaio.hrms.core.concretes;

import org.springframework.stereotype.Service;
import kodlamaio.hrms.core.abstracts.EmailService;

@Service
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