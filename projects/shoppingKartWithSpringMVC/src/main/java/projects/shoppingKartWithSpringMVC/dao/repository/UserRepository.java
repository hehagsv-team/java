package projects.shoppingKartWithSpringMVC.dao.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projects.shoppingKartWithSpringMVC.dao.entity.UserTable;




@Repository
public interface UserRepository extends JpaRepository<UserTable, String>{
	
	public List<UserTable> findByuserName(String userName);

	
}
