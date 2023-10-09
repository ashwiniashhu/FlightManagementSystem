package SpringBootProjects.FlightManagementSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringBootProjects.FlightManagementSystem.Model.Airport;
import SpringBootProjects.FlightManagementSystem.Model.FlightCompany;
@Service
public interface AirportService {
	
	     Airport updateDetailsUsingId(Airport airportObj,int airportId);
		void deleteAirportDetailsById(int airportId);
		Airport getDetailsById(int airportId);
		List<Airport> getAllAirportDetails();
		void deleteAirportDetails();
		Airport createAirportDetails(Airport airportObj);

		 List<Airport> searchByAirportName(String airportName);
}
