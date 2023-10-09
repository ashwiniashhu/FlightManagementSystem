package SpringBootProjects.FlightManagementSystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProjects.FlightManagementSystem.Model.FlightDetails;
import SpringBootProjects.FlightManagementSystem.Model.FlightFeedback;
import SpringBootProjects.FlightManagementSystem.Model.User;
import SpringBootProjects.FlightManagementSystem.Repository.FlightDetailsRepository;
import SpringBootProjects.FlightManagementSystem.Repository.FlightFeedbackRepository;
import SpringBootProjects.FlightManagementSystem.Repository.UserRepository;
import SpringBootProjects.FlightManagementSystem.Service.FlightFeedbackService;


@Service
public class FlightFeedbackServiceImpl implements FlightFeedbackService{

	@Autowired	
	private FlightFeedbackRepository flightFeedbackRepository;
	
	@Autowired
	private FlightDetailsRepository flightDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;

	//good flight/3/1
	@Override
	public FlightFeedback addFeedback(FlightFeedback feedback, Integer flightId, Long userId) throws Exception {
		
			
			Optional<FlightDetails> flightObj = flightDetailsRepository.findById(flightId);
			if (flightObj.isEmpty()) {
				throw new Exception("Flight is not present with flightId: "+flightId);
			}
			Optional<User> user = userRepository.findById(userId);//.orElseThrow(()-> new UserException("User not found!"));
			if (user.isEmpty()) {
				throw new Exception("User is not present with Id: "+ userId);
			}
			feedback.setFlightDetails(flightObj.get());
			feedback.setUser(user.get());
			FlightFeedback savedFeedback = flightFeedbackRepository.save(feedback);

			return savedFeedback;
			}


	@Override
	public void deleteFeedback(Integer feedbackId) {
		flightFeedbackRepository.deleteById(feedbackId);
		
	}

	@Override
	public FlightFeedback viewFeedback(Integer flightId) throws Exception {
		Optional<FlightFeedback> fedOptional = flightFeedbackRepository.findById(flightId);
		if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedback found!");
	
	}

	@Override
	public List<FlightFeedback> viewFeedbackAll() throws Exception {
		Optional<List<FlightFeedback>> fedOptional = Optional.of(flightFeedbackRepository.findAll());
			if (fedOptional.isPresent()) {
			return fedOptional.get();
		}
		throw new Exception("No feedbacks found!");
	
	}

}