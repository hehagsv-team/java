package projects.shoppingKartWithSpringMVC.dao.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projects.shoppingKartWithSpringMVC.dao.entity.HclSkItems;

public interface ItemsRepository extends JpaRepository<HclSkItems, Integer> {
	
		public List<HclSkItems> findAll();
//	
		@Query(value="select Id,Name,Price,Manufacturer_Id from HCL_SK_ITEM  where Price>=?1 and Price<=?2",nativeQuery=true)	
		 public List<HclSkItems> FindAllWithDescriptionQuery(Integer text1, Integer text2);
//		 public List<HclSkItems> FindByPriceBetween(Integer text1, Integer text2);
		
		 @Query(value="SELECT i.Id,i.Name,i.Price,i.Manufacturer_Id FROM HCL_SK_ITEM i JOIN HCL_SK_MANUFACTURER m on m.Id = i.Manufacturer_Id where m.name=?1",nativeQuery=true)
		 public List<HclSkItems> FindAllWithDescriptionQuery(String name);

}
