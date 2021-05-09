package tn.ConsomiTounsi.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.ConsomiTounsi.Entities.Category;





public interface CategoryRep  extends JpaRepository<Category, Integer> {
	 @Query(" select c from Category c " +
	            " where c.idcategory = ?1")
	    List<Category> findCategory(int category);

			

}

