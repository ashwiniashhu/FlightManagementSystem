package SpringBootProjects.FlightManagementSystem.Controller;

import java.util.List;
import java.util.ArrayList;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProjects.FlightManagementSystem.Model.FlightDetails;
import SpringBootProjects.FlightManagementSystem.Service.FlightDetailsService;

/*It is a combination of @Controller and @ResponseBody annotation
 * This annotation is used at the class level 
 * It allows the class to handle the requests made by the client
 * It allows to all handle all REST APIs such as GET,DELETE,POST,PUT requests
  */
@CrossOrigin
@RestController
@RequestMapping("/FlightReservation.com")
public class FlightDetailsController {
	
	//It is used to inject the dependency into a bean
	@Autowired
	private FlightDetailsService  flightDetailsService;
	
	public FlightDetailsController(FlightDetailsService flightDetailsService ) {
		this.flightDetailsService=flightDetailsService;
	}

	@PostMapping("/toCreateFd")
	public FlightDetails createFlightDetails(@RequestBody FlightDetails flightObj ){
		return flightDetailsService.createFlightDetails(flightObj);
	}
	
	@PutMapping("/updateById/{flightId}")
	public ResponseEntity<FlightDetails> updateFlightDetailsById(@PathVariable ("flightId")int flightId ,@RequestBody FlightDetails flightObj){
	try{
		return new ResponseEntity<FlightDetails>(flightDetailsService.updateDetailsUsingId(flightObj,flightId) , HttpStatus.OK);
	}catch(Exception exc) {
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
	}
	
	@GetMapping("/toReadFd")
	public List<FlightDetails> fetchAllFlightDetails(){
		return flightDetailsService.getAllFlightDetails();
	}
	
	@GetMapping("/readById/{flightId}")
	public ResponseEntity<FlightDetails> fetchFlightDetailsById(@PathVariable("flightId") int flightId){
		try{
			
			return new ResponseEntity<FlightDetails> (flightDetailsService.getDetailsById(flightId),HttpStatus.OK);
		}catch(Exception exc) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}
		}
	
	
	@DeleteMapping("/deleteById/{flightId}")
	public void deleteFlightDetailsById(@PathVariable int flightId) {
		flightDetailsService.deleteFlightDetailsById(flightId);
	}
	
	@DeleteMapping("/deleteFd")
	public void deleteFlightDetails() {
		flightDetailsService.deleteFlightDetails();
	}
	
	@GetMapping("/isDomesticFlight")
	public ResponseEntity<FlightDetails> fetchAllDomesticFlights(){
		
		try {
			return new ResponseEntity( flightDetailsService.checkIfFlightIsDomestic(true),HttpStatus.OK);
		}
		catch(Exception exc) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
	@GetMapping("/nonDomesticFlight")
	public ResponseEntity<FlightDetails> fetchAllNonDomesticFlights(){
			
	try {
				return new ResponseEntity( flightDetailsService.checkIfFlightIsNonDomestic(false),HttpStatus.OK);
			}
	catch(Exception exc) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}}
	
	@GetMapping("/getDetailsByFlightName/{flightName}")
	
	public ResponseEntity<List<FlightDetails>> fetchDetailsByFlightName(@PathVariable String flightName){
		try {
			List<FlightDetails> flightObj=flightDetailsService.searchByFlightName(flightName);
					
			if(flightObj.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(flightObj,HttpStatus.OK);
			}}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}}
    @GetMapping("/getDetailsBySourceAndDestination/{source}/{destination}")
	
	public ResponseEntity<List<FlightDetails>> fetchDetailsBySourceAndDestination(@PathVariable String source,@PathVariable String destination){
		try {
			List<FlightDetails> flightObj=flightDetailsService.searchBySourceAndDestination(source,destination);
					
			if(flightObj.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<>(flightObj,HttpStatus.OK);
			}}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		}
    @GetMapping("/fetchNameAndClassOfjourney/{flightName}/{classOfJourney}")

    public ResponseEntity<List<FlightDetails>> fetchDetailsByFlightNameAndClassOfJourney(@PathVariable String flightName,@PathVariable String classOfJourney){
			try {
				List<FlightDetails> flightObj=flightDetailsService.searchByFlightNameContainingIgnoreCaseAndClassOfJourney(flightName,classOfJourney);
						
				if(flightObj.isEmpty()) {
					
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<>(flightObj,HttpStatus.OK);
				}}
			catch(Exception exc) {
				
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			}

    
    @GetMapping("/sortByTicketCost/{direction}")
		
		public ResponseEntity<List<FlightDetails>> fetchDetailsByTicketCost(@PathVariable("direction") String direction,@RequestParam(required=true)String fieldName  ){
			try {
				List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
				flightObj=flightDetailsService.sortByTicketCost(direction,fieldName);
						
				if(flightObj.isEmpty()) {
					
					return new ResponseEntity<List<FlightDetails>>(HttpStatus.NO_CONTENT);
				}
				else {
					return new ResponseEntity<List<FlightDetails>>(flightObj,HttpStatus.OK);
				}
				}
			catch(Exception exc) {
				
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
			}
			}
    @GetMapping("/sortByFlightRating/{direction}")
	
	public ResponseEntity<List<FlightDetails>> fetchDetailsByRating(@PathVariable("direction") String direction,@RequestParam(required=true)String fieldName  ){
		try {
			List<FlightDetails> flightObj=new ArrayList<FlightDetails>();
			
			flightObj=flightDetailsService.sortByRating(direction,fieldName);
					
			if(flightObj.isEmpty()) {
				
				return new ResponseEntity<List<FlightDetails>>(HttpStatus.NO_CONTENT);
			}
			else {
				return new ResponseEntity<List<FlightDetails>>(flightObj,HttpStatus.OK);
			}
			}
		catch(Exception exc) {
			
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);	
		}
		}
	
		
}		
    
	