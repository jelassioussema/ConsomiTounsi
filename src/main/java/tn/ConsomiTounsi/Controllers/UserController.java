package tn.ConsomiTounsi.Controllers;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.ConsomiTounsi.Entities.Role;
import tn.ConsomiTounsi.Entities.User;
import tn.ConsomiTounsi.Services.IUserService;

import java.util.List;




@Scope(value = "session")
@Controller(value = "userController") // Name of the bean in Spring IoC 
@ELBeanName(value = "userController") // Name of the bean used by JSF  
@Join(path = "/", to = "/login.jsf")
public class UserController {

	@Autowired
	IUserService userService;

	private String login; 
	private String password; 
	private User user;
	private List<User> users; 
	private Long useridtobeupdated;
	private Boolean loggedIn;
	private float salaire;
	private String prenom; private String nom; private String email;
	private boolean actif; private Role role;

	private User authenticatedUser;  

	public String doLogin() {
		String navigateTo = "null";

		authenticatedUser=userService.authenticate(login, password);
		if (authenticatedUser != null && authenticatedUser.getRole() == Role.ADMINISTRATEUR) { 
			System.out.println("lol");
			navigateTo = "/pages/admin/welcome.xhtml?faces-redirect=false";
			loggedIn = true; }
		else {
			FacesMessage facesMessage =
					new FacesMessage("Login GHALET.");
			FacesContext.getCurrentInstance().addMessage("form:btn",facesMessage);
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public User getAuthenticatedUser() {
		return authenticatedUser;
	}

	public void setAuthenticatedUser(User authenticatedUser) {
		this.authenticatedUser = authenticatedUser;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

	public Long getUseridtobeupdated() {
		return useridtobeupdated;
	}

	public void setUseridtobeupdated(Long useridtobeupdated) {
		this.useridtobeupdated = useridtobeupdated;
	}
	

	public float getSalaire() {
		return salaire;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	/**********************************************************/
	
	public void adduser() {
		userService.addOrUpdateUser(new User(nom, prenom, email, password, actif, role));
		}
	public void removeuser(long id) {
		userService.deleteUser(id);
		}
	public Role[] getRoles() { return Role.values(); }

	public List<User> getUsers() {
	users = userService.getAllUsers();
	return users;
	}
	public void updateuser()
	{ userService.addOrUpdateUser(new User(useridtobeupdated,nom, prenom, email, password, actif, role)); }
	
	public void displayuser(User u){
		this.setPrenom(u.getFirstName());
		this.setNom(u.getLastName());
		this.setActif(u.isActive());
		this.setEmail(u.getEmail());
		this.setRole(u.getRole());
		this.setPassword(u.getPassword());
		this.setUseridtobeupdated(u.getId());
	}

}