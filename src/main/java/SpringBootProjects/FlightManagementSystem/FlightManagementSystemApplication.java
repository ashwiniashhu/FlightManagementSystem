package SpringBootProjects.FlightManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*This annotation is used to indicate that this is the main class of a Spring Boot Application
 *This is an annotation which will help me in scanning the components like Controller,Service and Repository 
 *It will create the beans and all of them will be stored in IOC container
 *As it is a web application you don't need to create IOC container it gets created automatically
 * 
 */
@SpringBootApplication
//This is the main class of the Spring Boot Application
public class FlightManagementSystemApplication {
	
	/*This is the Main method and it is the entry point of my Spring boot project
	 *It's where my application starts execution.
	 */
    public static void main(String[] args) {
    	
    	//This line Runs the Spring Boot Application
		SpringApplication.run(FlightManagementSystemApplication.class, args);
		
	}

}

