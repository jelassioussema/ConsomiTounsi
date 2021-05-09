package tn.ConsomiTounsi.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.ConsomiTounsi.Entities.Role;
import tn.ConsomiTounsi.Entities.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByFirstName(String fname);

	List<User> findByLastName(String lname);

	List<User> findByIdGreaterThan(Long id);
	
	User getUserByEmailAndPassword(String login, String password);

	
	//******************* Tp JPQL ********************************
	
		//******************* SELECT ******************
	
	@Query("SELECT u FROM User u WHERE u.role= :role")
	List<User> retrieveUsersByRole(@Param("role") Role role);  
	
	@Query("SELECT u FROM User u WHERE u.role= ?1")
	List<User> retrieveUsersByRole2(Role role);  
	
	@Query(value = "SELECT * FROM T_USER u WHERE u.role= :role " , nativeQuery = true)
	List<User> retrieveUsersByRole3(@Param("role") Role role);  
	
	@Query(value = "SELECT * FROM T_USER u WHERE u.role= ?1 " , nativeQuery = true)
	List<User> retrieveUsersByRole4(Role role);  
	
		//******************* UPDATE ******************
	
	@Modifying
	@Query("update User u set u.role = :role where u.firstName = :fname")
	int updateUserStatusByFirstName(@Param("role") Role role, @Param("fname") String fname);
	
	@Modifying
	@Query("update User u set u.role = ?1 where u.firstName = ?2")
	int updateUserStatusByFirstName2(Role role,String fname);
	
	@Modifying
	@Query(value = "update T_User u set u.role = :role where u.firstName = :fname", nativeQuery = true)
	int updateUserStatusByFirstName3(@Param("role") Role role, @Param("fname") String fname);
	
	@Modifying
	@Query(value = "update T_User u set u.role = ?1 where u.firstName = ?2", nativeQuery = true)
	int updateUserStatusByFirstName4(Role role,String fname);
	
		//******************* DELETE ******************
	
	@Modifying
	@Query("DELETE FROM User u WHERE u.role = :role AND u.firstName = :fname")
	int deleteUserByStatusAndFirstName(@Param("role") Role role, @Param("fname") String fname);
	
		//******************* INSERT ******************
	
	@Modifying
	@Query(value = "INSERT INTO T_User (first_name, last_name, role) VALUES (:fn, :ln, :role)", nativeQuery = true)
	void insertUser(@Param("fn") String fn, @Param("ln") String ln, @Param("role") String role);

}