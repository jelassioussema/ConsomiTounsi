package tn.ConsomiTounsi.Services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.ConsomiTounsi.Entities.Category;
import tn.ConsomiTounsi.Repositories.CategoryRep;




@Service
@Transactional
public class CategoryService implements ICategoryService {
	@Autowired 
	CategoryRep crp;
	@Override
	public List<Category> getAllcategory() {
		// TODO Auto-generated method stub
		return crp.findAll();
	}

	@Override
	public Category getByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Category category) {
		// TODO Auto-generated method stub
		crp.save(category);
	}

	@Override
	public void deletecategory(int id) {
		// TODO Auto-generated method stub
		crp.deleteById(id);
	}

	@Override
	public Category updatecategory(int id, Category category) {
		// TODO Auto-generated method stub
		Category gr1 = crp.findById(id).get();
		gr1.setNamecategory(category.getNamecategory());
		return crp.save(gr1);
	}

}

