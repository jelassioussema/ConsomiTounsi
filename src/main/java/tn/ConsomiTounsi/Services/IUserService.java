package tn.ConsomiTounsi.Services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import tn.ConsomiTounsi.Entities.Role;
import tn.ConsomiTounsi.Entities.User;



public interface IUserService {
	
	List<User> retrieveAllUsers();
	User addUser(User u);
	void deleteUser(Long id);
	void deleteUser(String id);
	User updateUser(User u);
	User retrieveUser(Long id);
	User retrieveUser(String id);
	List<User> findByIdGreaterThan(Long id);
	List<User> findByFirstName(String fname);
	List<User> findByLastName(String lname);
	User authenticate(String login, String password);
	// JPQL
	@Transactional
	void insertUser(String fn, String ln, Role role);
	@Transactional
	int deleteUserByStatusAndFirstName(Role role,String fname);
	@Transactional
	List<User> retrieveUsersByRole4(Role role);  
	@Transactional
	int updateUserStatusByFirstName(Role role,String fname);
	int addOrUpdateUser(User u);
	public List<User> getAllUsers();

}
