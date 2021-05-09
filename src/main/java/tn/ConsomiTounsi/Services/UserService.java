package tn.ConsomiTounsi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.ConsomiTounsi.Entities.Role;
import tn.ConsomiTounsi.Entities.User;
import tn.ConsomiTounsi.Repositories.UserRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class UserService implements IUserService {

	private static final Logger l = LogManager.getLogger(UserService.class);

	@Autowired
	UserRepository repository;

	@Override
	public List<User> retrieveAllUsers() {
		
		return (List<User>) repository.findAll();
		
		// Ou bien
		// List<User> users = (List<User>) repository.findAll();
		// for (User user : users) {
		// l.info("user +++ : " + user);
		// }
		// return users;
	}

	@Override
	public User addUser(User u) {
		return repository.save(u);
	}

	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);

	}

	@Override
	public User updateUser(User u) {
		return repository.save(u);
	}

	@Override
	public User retrieveUser(Long id) {
		return repository.findById(id).orElse(new User());
	}

	@Override
	public void deleteUser(String id) {
		repository.deleteById(Long.parseLong(id));
	}

	@Override
	public User retrieveUser(String id) {
		return repository.findById(Long.parseLong(id)).orElse(null);
	}

	@Override
	public List<User> findByIdGreaterThan(Long id) {
		return repository.findByIdGreaterThan(id);
	}

	@Override
	public List<User> findByFirstName(String fname) {
		return repository.findByFirstName(fname);
	}

	@Override
	public List<User> findByLastName(String lname) {
		return repository.findByLastName(lname);
	}

	@Override
	public void insertUser(String fn, String ln, Role role) {
		repository.insertUser(fn, ln, role.toString());
		
	}

	@Override
	public int deleteUserByStatusAndFirstName(Role role, String fname) {
		return repository.deleteUserByStatusAndFirstName(role, fname);
	}

	@Override
	public List<User> retrieveUsersByRole4(Role role) {
		return repository.retrieveUsersByRole4(role);
	}

	@Override
	public int updateUserStatusByFirstName(Role role, String fname) {
		return repository.updateUserStatusByFirstName(role, fname);
	}

	@Override
	public User authenticate(String login, String password) {
		return repository.getUserByEmailAndPassword(login, password);
	}

	@Override
	public int addOrUpdateUser(User u) {
		repository.save(u);
		return u.getId().intValue();
	}

	@Override
	public List<User> getAllUsers() {
		return (List<User>) repository.findAll();
	}


}
