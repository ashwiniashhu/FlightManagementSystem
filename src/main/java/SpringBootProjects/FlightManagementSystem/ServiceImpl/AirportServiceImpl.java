package SpringBootProjects.FlightManagementSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProjects.FlightManagementSystem.Model.Airport;
import SpringBootProjects.FlightManagementSystem.Repository.AirportRepository;
import SpringBootProjects.FlightManagementSystem.Service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {

	
	 private AirportRepository airportRepository;
		
	    @Autowired
		public AirportServiceImpl(AirportRepository airportRepository) {
			this.airportRepository=airportRepository;
		}
	@Override
	public Airport updateDetailsUsingId(Airport airportObj, int airportId) {
		Optional<Airport> airportFromDb = airportRepository.findById(airportId); 
		if(airportFromDb.isPresent()) {
			Airport existingAirport=airportFromDb.get();
			
			existingAirport.setAirportName(airportObj.getAirportName());
			existingAirport.setAirportCity(airportObj.getAirportCity());
		
			airportRepository.save(existingAirport);
			
			return existingAirport;
			}
		else {
			return null;
		}
		}

	@Override
	public void deleteAirportDetailsById(int airportId) {
		Optional<Airport> airportObj = airportRepository.findById(airportId);  
		if(airportObj.isPresent()) {
			airportRepository.deleteById(airportId);
		}

	}

	@Override
	public Airport getDetailsById(int airportId) {
		Optional<Airport> airportObj = airportRepository.findById(airportId);  //null , or it can 5tg person rec
		if(airportObj.isPresent()) {
			return airportObj.get();
		}
		else {
			return null;
		}
	}

	@Override
	public List<Airport> getAllAirportDetails() {
		return airportRepository.findAll();
	}

	@Override
	public void deleteAirportDetails() {
		airportRepository.deleteAll();
	}

	@Override
	public Airport createAirportDetails(Airport airportObj) {
		return airportRepository.save(airportObj);
	}
	@Override
	public List<Airport> searchByAirportName(String airportName) {
		return airportRepository.findByAirportNameContainingIgnoreCase(airportName);
	}

}
