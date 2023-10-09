package SpringBootProjects.FlightManagementSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import SpringBootProjects.FlightManagementSystem.Model.FlightDetails;

//It is used to denote a class that perform a specific service or function in a spring boot application
@Service
public interface FlightDetailsService {
	

	    FlightDetails updateDetailsUsingId(FlightDetails flightObj,int flightId);
		void deleteFlightDetailsById(int flightId);
		FlightDetails getDetailsById(int flightId);
		List<FlightDetails> getAllFlightDetails();
		void deleteFlightDetails();
		FlightDetails createFlightDetails(FlightDetails flightObj);
		 		
		List<FlightDetails> checkIfFlightIsDomestic(Boolean booleanObj) ;
		List<FlightDetails> checkIfFlightIsNonDomestic(Boolean booleanObj) ;
        List<FlightDetails> searchByFlightName(String flightName);
		List<FlightDetails> searchBySourceAndDestination(String source,String destination);
		List<FlightDetails> searchByFlightNameContainingIgnoreCaseAndClassOfJourney(String flightName,String classOfJourney);

		List<FlightDetails> sortByTicketCost(String direction, String fieldName);
		List<FlightDetails> sortByRating(String direction, String fieldName);
		
	
		
		

		  
		

	

}
