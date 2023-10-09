package SpringBootProjects.FlightManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProjects.FlightManagementSystem.Model.FlightFeedback;

@Repository

public interface FlightFeedbackRepository extends JpaRepository<FlightFeedback,Integer>{

	
	
}