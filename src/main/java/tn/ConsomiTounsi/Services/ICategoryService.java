package tn.ConsomiTounsi.Services;

import java.util.List;

import tn.ConsomiTounsi.Entities.Category;



public interface ICategoryService {
	public List<Category> getAllcategory();
	public  Category getByid(int id);
	public void saveOrUpdate(Category category);
	public void deletecategory(int id);
	public Category updatecategory(int id, Category category);
}
