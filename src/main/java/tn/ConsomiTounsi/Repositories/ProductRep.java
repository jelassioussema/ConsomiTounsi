package tn.ConsomiTounsi.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.ConsomiTounsi.Entities.Product;




public interface ProductRep  extends JpaRepository<Product, Integer> {
	@Query(value ="SELECT * FROM product WHERE nameproduct LIKE %:name%", nativeQuery = true)
	public List<Product> recherche(@Param(value = "name") String name);
	@Query(value=" select * from product  where category_idcategory =  (select idcategory from category where namecategory LIKE %:name% )", nativeQuery = true)
	 List<Product> findProducts(@Param(value = "name") String name);

}
