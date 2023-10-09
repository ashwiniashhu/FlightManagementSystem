package SpringBootProjects.FlightManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProjects.FlightManagementSystem.Model.FlightFeedback;
import SpringBootProjects.FlightManagementSystem.Service.FlightFeedbackService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "")
@RequestMapping("/FlightReservation.com")
public class FlightFeedbackController {
	


		@Autowired
		private FlightFeedbackService feedbackService;
		
		@PostMapping("/add/{flightId}/{userId}")
		public ResponseEntity<FlightFeedback> addFeedback(@Valid @RequestBody FlightFeedback flightfeedback1,
													@PathVariable("flightId") int flightId,@PathVariable("userId")Long userId) throws Exception{
			
			FlightFeedback feedback = feedbackService.addFeedback(flightfeedback1, flightId, userId);
			
			return new ResponseEntity<FlightFeedback>(feedback,HttpStatus.ACCEPTED);
			
		}

		@GetMapping("/feedback/{flightId}")
		public ResponseEntity<FlightFeedback> viewFeedback(@PathVariable("flightId") Integer FlightID) throws Exception {
			
			FlightFeedback feedback = feedbackService.viewFeedback(FlightID);
			
			return new ResponseEntity<FlightFeedback>(feedback,HttpStatus.ACCEPTED);
			
		}
		@GetMapping("/feedback/all")
		public ResponseEntity<List<FlightFeedback>> viewFeedbackAll() throws Exception  {
			
			List<FlightFeedback> feedback =  feedbackService.viewFeedbackAll();
			
			return new ResponseEntity<List<FlightFeedback>>(feedback,HttpStatus.ACCEPTED);
			
		}
		@DeleteMapping("feedback/delete/{flightId}")
		public void deleteFeedback(@PathVariable("flightId") Integer feedbackId) throws Exception{
			
			 feedbackService.deleteFeedback(feedbackId);
			
			
			
		}
	}


