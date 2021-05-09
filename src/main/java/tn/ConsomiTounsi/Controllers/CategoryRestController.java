package tn.ConsomiTounsi.Controllers;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.transaction.Transactional;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import tn.ConsomiTounsi.Entities.Category;
import tn.ConsomiTounsi.Entities.Role;
import tn.ConsomiTounsi.Entities.User;
import tn.ConsomiTounsi.Repositories.CategoryRep;
import tn.ConsomiTounsi.Services.CategoryService;




@Scope(value = "session")
@Controller(value = "CategoryRestController") // Name of the bean in Spring IoC 
@ELBeanName(value = "CategoryRestController") // Name of the bean used by JSF  
@Join(path = "/", to = "/category.jsf")
public class CategoryRestController{
	@Autowired
	CategoryService ser;
	@Autowired
	CategoryRep cr;
	

	private int idcategory;
	
	
	private String namecategory;
	
	private int catidtobeupdated;
	
	private List<Category> categories; 
	
	
	@PostMapping("/save")
	public Category save(@RequestBody Category category)
	{
		ser.saveOrUpdate(category);
			return category;
	 }
	
	@GetMapping("/list")
	public List<Category> listproduct(){
			
		
			
			return ser.getAllcategory();
		}
	
	@DeleteMapping("/delete/{id}")
	public  String deleteproduct(@PathVariable(value = "id")int id){
		
		ser.deletecategory(id);
		return "Deleted succesfully id= "+id;
	}
	
	@PutMapping("/update/{id}")
	public Category updatecategory(@PathVariable (value = "id")int id,@RequestBody Category category)
	{
		
		return ser.updatecategory(id, category);
	}

	public int getIdcategory() {
		return idcategory;
	}

	public void setIdcategory(int idcategory) {
		this.idcategory = idcategory;
	}

	public String getNamecategory() {
		return namecategory;
	}

	public void setNamecategory(String namecategory) {
		this.namecategory = namecategory;
	}
	
	
	
	
	


	public int getCatidtobeupdated() {
		return catidtobeupdated;
	}

	public void setCatidtobeupdated(int catidtobeupdated) {
		this.catidtobeupdated = catidtobeupdated;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public void addcategory() {
		ser.saveOrUpdate(new Category(namecategory));
		
		}
	public void removecategory(int id) {
		ser.deletecategory(id);
		
		}


	public List<Category> getCategories() {
		categories = ser.getAllcategory();
	
	return categories;
	}
	public void updatecategory()
	{ 
		ser.saveOrUpdate(new Category(catidtobeupdated, namecategory));
		 }
	
	public void displaycategory(Category c){
		this.setNamecategory(c.getNamecategory());
		this.setCatidtobeupdated(c.getIdcateory());
	}
	
	

}
