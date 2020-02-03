package projects.shoppingKartWithSpringMVC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages= {"projects.shoppingKartWithSpringMVC.web","projects.shoppingKartWithSpringMVC.dao"})
//@ComponentScan("projects.shoppingKartWithSpringMVC.web","thSpringMVC.web.dao")
@ComponentScan
public class ShoppingKartWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingKartWebApplication.class, args);
	}

}
                                                                        