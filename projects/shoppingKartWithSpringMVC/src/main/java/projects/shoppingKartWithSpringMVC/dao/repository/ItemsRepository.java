package projects.shoppingKartWithSpringMVC.dao.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projects.shoppingKartWithSpringMVC.dao.entity.HclSkItems;

public interface ItemsRepository extends JpaRepository<HclSkItems, Integer> {
	
//		public List<HclSkItems> findAll();
		
		@Query(value="select * from (select RowNum rnum, a.* from (select RowNum,Id,Name,Price,Manufacturer_Id from HCL_SK_ITEM) a where RowNum <= ?1 ) where rnum >= ?2",nativeQuery=true)	
		 public List<HclSkItems> FindAllWithRowNumQuery(Integer end,Integer start);
//	select * from (select RowNum rnum, a.* from (select RowNum,Id,Name,Price,Manufacturer_Id from HCL_SK_ITEM  where Price>=?1 and Price<=?2) a where RowNum <= ?2 ) where rnum >= ?3"
		@Query(value="select * from (select RowNum rnum, a.* from (select RowNum,Id,Name,Price,Manufacturer_Id from HCL_SK_ITEM  where Price>=?1 and Price<=?2) a where RowNum <=?3 ) where rnum >=?4",nativeQuery=true)
		public List<HclSkItems> FindAllWithDescriptionQuery(Integer text1, Integer text2,Integer end, Integer start);
//		 public List<HclSkItems> FindByPriceBetween(Integer text1, Integer text2);
		@Query(value="select * from (select RowNum rnum, a.* from (select RowNum,i.Id,i.Name,i.Price,i.Manufacturer_Id FROM HCL_SK_ITEM i JOIN HCL_SK_MANUFACTURER m on m.Id = i.Manufacturer_Id where m.name=?1) a where RowNum <= ?2 ) where rnum >= ?3",nativeQuery=true)
		 public List<HclSkItems> FindAllWithDescriptionQuery(String name,Integer end, Integer start);

//		 @Query(value="SELECT RowNum,i.Id,i.Name,i.Price,i.Manufacturer_Id FROM HCL_SK_ITEM i JOIN HCL_SK_MANUFACTURER m on m.Id = i.Manufacturer_Id where m.name=?1",nativeQuery=true)
//		 public List<HclSkItems> FindAllWithDescriptionQuery(String name);

//		@Query(value="select count(*) from (select RowNum,i.Id,i.Name,i.Price,i.Manufacturer_Id FROM HCL_SK_ITEM i JOIN HCL_SK_MANUFACTURER m on m.Id = i.Manufacturer_Id where m.name=?1 ) a",nativeQuery=true)
//		public HclSkItems FindAllWithDescriptionQuery(String name);
		
		@Query(value="select RowNum,i.Id,i.Name,i.Price,i.Manufacturer_Id FROM HCL_SK_ITEM i JOIN HCL_SK_MANUFACTURER m on m.Id = i.Manufacturer_Id where m.name=?1",nativeQuery=true)
        public List<HclSkItems> FindAllWithDescriptionQuery(String name);
		
		@Query(value="select RowNum,Id,Name,Price,Manufacturer_Id from HCL_SK_ITEM",nativeQuery=true)
        public List<HclSkItems> FindAllWithDescriptionQuery();
		
		@Query(value="select RowNum,Id,Name,Price,Manufacturer_Id from HCL_SK_ITEM  where Price>=?1 and Price<=?2",nativeQuery=true)
        public List<HclSkItems> FindAllWithDescriptionQuery(Integer text1,Integer text2);
	
}
