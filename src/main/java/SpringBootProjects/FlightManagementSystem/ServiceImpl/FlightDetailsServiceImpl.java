package SpringBootProjects.FlightManagementSystem.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import SpringBootProjects.FlightManagementSystem.Model.FlightDetails;
import SpringBootProjects.FlightManagementSystem.Repository.FlightDetailsRepository;
import SpringBootProjects.FlightManagementSystem.Service.FlightDetailsService;
//It is used to denote a class that perform a specific service or function in a spring boot application
@Service
public class FlightDetailsServiceImpl implements FlightDetailsService {

	
	private FlightDetailsRepository flightDetailsRepository;
	
    @Autowired
	public FlightDetailsServiceImpl(FlightDetailsRepository flightDetailsRepository) {
		this.flightDetailsRepository=flightDetailsRepository;
	}
	@Override
	public FlightDetails createFlightDetails(FlightDetails flightObj) {
		return flightDetailsRepository.save(flightObj);
	}

	@Override
	public  FlightDetails  updateDetailsUsingId( FlightDetails flightObj,int flightId) {
		Optional<FlightDetails> flightDetailsFromDb = flightDetailsRepository.findById(flightId); 
if(flightDetailsFromDb.isPresent()) {
	FlightDetails existingFlightDetails=flightDetailsFromDb.get();
	
	existingFlightDetails.setTicketCost(flightObj.getTicketCost());
	existingFlightDetails.setRating(flightObj.getRating());
	existingFlightDetails.setFlightName(flightObj.getFlightName());
	existingFlightDetails.setFlightNumber(flightObj.getFlightNumber());
	existingFlightDetails.setIsDomestic(flightObj.getIsDomestic());
	existingFlightDetails.setDuration(flightObj.getDuration());
	existingFlightDetails.setClassOfJourney(flightObj.getClassOfJourney());
	existingFlightDetails.setDestination(flightObj.getDestination());
	existingFlightDetails.setSource(flightObj.getSource());


	
	flightDetailsRepository.save(existingFlightDetails);
	
	return existingFlightDetails;
	}
else {
	return null;
}
}

	
	@Override
	public List<FlightDetails> getAllFlightDetails() {
		return flightDetailsRepository.findAll();
	}
	
	
	
	@Override
	public FlightDetails getDetailsById(int flightId) {
			Optional<FlightDetails> flightObj = flightDetailsRepository.findById(flightId);  //null , or it can 5tg person rec
			if(flightObj.isPresent()) {
				return flightObj.get();
			}
			else {
				return null;
			}
	}
	@Override
	public void deleteFlightDetailsById(int flightId) {
		Optional<FlightDetails> flightObj = flightDetailsRepository.findById(flightId);  //null , or it can 5tg person rec
		if(flightObj.isPresent()) {
			flightDetailsRepository.deleteById(flightId);
		}
	}
	@Override
	public void deleteFlightDetails() {
		flightDetailsRepository.deleteAll();
	}
	@Override
	public List<FlightDetails> checkIfFlightIsDomestic(Boolean booleanObj )  {
		
			List<FlightDetails> flightObj= flightDetailsRepository.findByIsDomestic(true);
			return flightObj;
	}
	@Override
	public List<FlightDetails> searchByFlightName(String flightName) {
		return flightDetailsRepository.findByFlightNameContainingIgnoreCase(flightName);

	}
	@Override
	public List<FlightDetails> searchBySourceAndDestination(String source, String destination) {
		return flightDetailsRepository.findBySourceAndDestination(source,destination);

	}
	@Override
	public List<FlightDetails> searchByFlightNameContainingIgnoreCaseAndClassOfJourney(String flightName,String classOfJourney) {
		 return flightDetailsRepository.findByFlightNameContainingIgnoreCaseAndClassOfJourney(flightName,classOfJourney);

	}	
	
	private Sort.Direction getSortDirection(String direction){
		if (direction.equalsIgnoreCase("asc")) {
			return Sort.Direction.ASC;
		}else if(direction.equalsIgnoreCase("desc")) {
			return Sort.Direction.DESC;
			}
		return Sort.Direction.ASC;
	}
	
public List<FlightDetails> sortByTicketCost(String direction, String fieldName) {
		
		List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
		flightObj=flightDetailsRepository.findAll(Sort.by(getSortDirection(direction),fieldName));
		return flightObj;
		
	}
    @Override
public List<FlightDetails> sortByRating(String direction, String fieldName) {
    	List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
		flightObj=flightDetailsRepository.findAll(Sort.by(getSortDirection(direction),fieldName));
		return flightObj;
		}
	@Override
	public List<FlightDetails> checkIfFlightIsNonDomestic(Boolean booleanObj) {
		List<FlightDetails> flightObj= flightDetailsRepository.findByIsDomestic(false);
		return flightObj;
	}
	}
	
	
	
	

	


