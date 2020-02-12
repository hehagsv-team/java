package projects.shoppingKartWithSpringMVC.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projects.shoppingKartWithSpringMVC.dao.entity.*;

@Repository
public interface PriceRepository extends JpaRepository<HclSkItems, Integer>{
	 
	
	@Query(value="select i.Id,i.Name,i.Price from HCL_SK_ITEM i where i.price between ?1 and ?2",nativeQuery=true)	
	 public List<HclSkItems> FindAllWithDescriptionQuery(Integer text1, Integer text2);
//	ArrayList<HCL_SK_ITEM> findByPriceBetween(Integer r1, Integer r2);	
//	select name,price from Hcl_Sk_Item where price between "+range1+" and "+range2
		
}

