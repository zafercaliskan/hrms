package kodlamaio.hrms.core.abstracts;

public interface EmailService {	
	boolean verifyTheVerificationCode(String verificationCode);
	void sendVerificationMail(String email, String content);
}