package SpringBootProjects.FlightManagementSystem.Repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import SpringBootProjects.FlightManagementSystem.Model.FlightDetails;
//It is used to indicate that the class provides the mechanism for storage,retrieval,search,update and delete operation on objects
@Repository
public interface FlightDetailsRepository  extends JpaRepository<FlightDetails,Integer> {

	List<FlightDetails> findByIsDomestic(Boolean booleanObj);
	List<FlightDetails> findByFlightNameContainingIgnoreCase(String flightName);
	List<FlightDetails> findBySourceAndDestination(String source,String destination );
	List<FlightDetails> findByFlightNameContainingIgnoreCaseAndClassOfJourney(String flightName,String classOfJourney);
	
}
