package tn.ConsomiTounsi.Entities;



import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;





@Entity
@Table(name ="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idproduct")
	private int idproduct;
	
	@Column(name="nameproduct")
	private String nameproduct;
	@NotEmpty(message = "*Please provide a name for product")
	
	@Column(name="priceproduct")
	private float priceproduct;
	@NotEmpty(message = "*Please provide a price for product")
	
	
	@Column(name="quantityproduct")
	private float quantityproduct;
	@NotEmpty(message = "*Please provide the quantity")
	
	@Column(name="barcode")
	private String barcode;
	
	@Column(name="weightproduct")
	private float weightproduct;
	@NotEmpty(message = "*Please provide the weight")
	
	@Column(name="imageproduct")
	private String imageProduct;
	@NotEmpty(message = "*Upload an image for product")
	
	@Temporal(TemporalType.DATE)
	@Column(name="dateproduct")
	private Date dateProduct;
	
	@ManyToOne
	Category Category;


	


	public int getIdproduct() {
		return idproduct;
	}

	public void setIdproduct(int idproduct) {
		this.idproduct = idproduct;
	}

	public float getPriceproduct() {
		return priceproduct;
	}

	public void setPriceproduct(float priceproduct) {
		this.priceproduct = priceproduct;
	}



	public float getQuantityproduct() {
		return quantityproduct;
	}

	public void setQuantityproduct(float quantityproduct) {
		this.quantityproduct = quantityproduct;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public float getWeightproduct() {
		return weightproduct;
	}

	public void setWeightproduct(float weightproduct) {
		this.weightproduct = weightproduct;
	}


	
	
	public String getImageProduct() {
		return imageProduct;
	}



	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}


	public String getNameproduct() {
		return nameproduct;
	}

	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}



	public Product() {
		super();
	}

	public Date getDateProduct() {
		return dateProduct;
	}

	public void setDateProduct(Date dateProduct) {
		this.dateProduct = dateProduct;
	}

	public Product(int idproduct) {
		super();
		this.idproduct = idproduct;
	}

	public Product(int idproduct,
			@NotEmpty(message = "*Please provide a name for product")String nameproduct,
			@NotEmpty(message = "*Please provide a price for product")float priceproduct,
			@NotEmpty(message = "*Please provide the quantity")float quantityproduct, 
			String barcode,
			@NotEmpty(message = "*Please provide the weightproduct")float weightproduct, 
			@NotEmpty(message = "*Upload an image for product")String imageProduct, 
			Date dateProduct, tn.ConsomiTounsi.Entities.Category category) {
		super();
		this.idproduct = idproduct;
		this.nameproduct = nameproduct;
		this.priceproduct = priceproduct;
		this.quantityproduct = quantityproduct;
		this.barcode = barcode;
		this.weightproduct = weightproduct;
		this.imageProduct = imageProduct;
		this.dateProduct = dateProduct;
		Category = category;
		
	}

	
	public Product(String nameproduct) {
		super();
		this.nameproduct = nameproduct;
	}
	
	

	public Product(String nameproduct, @NotEmpty(message = "*Please provide a name for product") float priceproduct,
			@NotEmpty(message = "*Please provide a price for product") float quantityproduct,
			@NotEmpty(message = "*Please provide the quantity") String barcode, float weightproduct,
			@NotEmpty(message = "*Please provide the weight") String imageProduct,
			@NotEmpty(message = "*Upload an image for product") Date dateProduct,
			tn.ConsomiTounsi.Entities.Category category) {
		super();
		this.nameproduct = nameproduct;
		this.priceproduct = priceproduct;
		this.quantityproduct = quantityproduct;
		this.barcode = barcode;
		this.weightproduct = weightproduct;
		this.imageProduct = imageProduct;
		this.dateProduct = dateProduct;
		Category = category;
	}

	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", nameproduct=" + nameproduct + ", priceproduct=" + priceproduct
				+ ", quantityproduct=" + quantityproduct + ", barcode=" + barcode + ", weightproduct=" + weightproduct
				+ ", imageProduct=" + imageProduct + ", dateProduct=" + dateProduct + ", Category=" + Category.getNamecategory() + "]";
	}




	
	
	
	
	
	
	
	
	
	
	
	
}
