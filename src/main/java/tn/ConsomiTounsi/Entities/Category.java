package tn.ConsomiTounsi.Entities;



import java.util.List;


import javax.persistence.*;




@Entity
@Table(name ="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcategory")
	private int idcategory;
	
	@Column(name="namecategory")
	private String namecategory;
	
	

	
	@OneToMany(mappedBy = "Category")
	private List<Product> Product;

	public Category() {
		super();
	}

	public Category(int idcateory, String namecategory) {
		super();
		this.idcategory = idcateory;
		this.namecategory = namecategory;
		
	}
	
	

	public Category(String namecategory) {
		super();
		this.namecategory = namecategory;
	}

	public int getIdcateory() {
		return idcategory;
	}

	public void setIdcateory(int idcategory) {
		this.idcategory = idcategory;
	}

	public String getNamecategory() {
		return namecategory;
	}

	public void setNamecategory(String namecategory) {
		this.namecategory = namecategory;
	}


	
	
}
