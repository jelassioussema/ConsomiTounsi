package tn.ConsomiTounsi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.User;
import tn.ConsomiTounsi.Services.IUserService;



@RestController
@RequestMapping("/user")
public class UserControllerRest {

	   @Autowired 
	   IUserService userService; 
	 
	   // http://localhost:8081/SpringMVC/servlet/retrieve-all-users
	   @GetMapping("/retrieve-all-users")
	   public List<User> getUsers() {
	          List<User> list = userService.retrieveAllUsers();
	          return list;
	   } 

	   // http://localhost:8081/SpringMVC/servlet/retrieve-user/2
	   @GetMapping("/retrieve-user/{user-id}")
	   public User retrieveUser(@PathVariable("user-id") String userId) {
	      return userService.retrieveUser(userId);
	   } 
	   
	   // http://localhost:8081/SpringMVC/servlet/retrieve-user?id=1
	   @GetMapping("/retrieve-user")
	   public User retrieveUser2(@RequestParam("id") String userId) {
	      return userService.retrieveUser(userId);
	   } 
	   
	   // Ajouter User : http://localhost:8081/SpringMVC/servlet/add-user
	   @PostMapping("/add-user")
	   public User addUser(@RequestBody User u) {
	      User user = userService.addUser(u); 
	      return user;
	   }

	   // http://localhost:8081/SpringMVC/servlet/remove-user/{user-id}
	   @DeleteMapping("/remove-user/{user-id}") 
	   public void removeUser(@PathVariable("user-id") String userId) { 
	      userService.deleteUser(userId);
	   } 

	   // http://localhost:8081/SpringMVC/servlet/modify-user 
	   @PutMapping("/modify-user") 
	   public User modifyUser(@RequestBody User user) {
	      return userService.updateUser(user);
	   }

}