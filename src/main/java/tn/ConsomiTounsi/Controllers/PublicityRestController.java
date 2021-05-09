package tn.ConsomiTounsi.Controllers;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.ConsomiTounsi.Entities.Publicity;
import tn.ConsomiTounsi.Repositories.PublicityRep;
import tn.ConsomiTounsi.Services.PublicityService;






@RestController
@Transactional
@EnableAutoConfiguration
@RequestMapping(value ="/publicity")
public class PublicityRestController{
	@Autowired
	PublicityService ser;
	@Autowired
	PublicityRep cr;
	@PostMapping("/save")
	public Publicity save(@RequestBody Publicity publicity)
	{
		ser.saveOrUpdate(publicity);
			return publicity;
	 }
	
	@GetMapping("/list")
	public List<Publicity> listpublicity(){
			
		
			
			return ser.getAllpublicity();
		}
	
	@DeleteMapping("/delete/{id}")
	public  String deletepublicity(@PathVariable(value = "id")int id){
		
		ser.deletepublicity(id);
		return "Deleted succesfully id= "+id;
	}
	
	@PutMapping("/update/{id}")
	public Publicity updatepublicity(@PathVariable (value = "id")int id,@RequestBody Publicity publicity)
	{
		
		return ser.updatepublicity(id, publicity);
	}
	

}

