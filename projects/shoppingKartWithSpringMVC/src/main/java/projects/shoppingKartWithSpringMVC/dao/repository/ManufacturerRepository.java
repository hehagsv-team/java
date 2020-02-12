package projects.shoppingKartWithSpringMVC.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projects.shoppingKartWithSpringMVC.dao.entity.HclSkItems;
import projects.shoppingKartWithSpringMVC.dao.entity.HclSkManufacturer;

	public interface ManufacturerRepository extends JpaRepository<HclSkManufacturer, Integer> {
		
	public List<HclSkManufacturer> findAll();
		// TODO Auto-generated method stub
	
	}


