package tn.ConsomiTounsi.Services;

import java.util.List;

import tn.ConsomiTounsi.Entities.Product;




public interface IProductService {
	public List<Product> getAllproduct();
	public  Product getByid(int id);
	public void saveOrUpdate(Product product);
	public void deleteproduct(int id);
	public Product updateproduct(int id, Product product);
	
}