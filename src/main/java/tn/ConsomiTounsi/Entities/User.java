package tn.ConsomiTounsi.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "T_User")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "U_id")
	private Long id;
    private boolean active;
	private String firstName;

	private String lastName;


	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;

	@Temporal(TemporalType.DATE)
	private Date date;
	
	private String email;
	
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstNmae() {
		return firstName;
	}

	public void setFirstNmae(String firstNmae) {
		this.firstName = firstNmae;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public User() {
		super();
	}

	public User(String firstName, String lastName, Date date, Role role,Boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.date = date;
		this.active = active;
	}
	public User(String firstName, String lastName,String email ,String password,Boolean active,Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password=password;
		this.active = active;
		this.role=role;
	}
	public User(long id,String firstName, String lastName,String email ,String password,Boolean active,Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password=password;
		this.active = active;
		this.id=id;
		this.role=role;

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", date="
				+ date + "]";
	}

}