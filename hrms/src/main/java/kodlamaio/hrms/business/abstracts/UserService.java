package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
	Optional<User> get(int id);
}