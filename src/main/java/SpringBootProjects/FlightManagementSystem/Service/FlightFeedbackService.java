package SpringBootProjects.FlightManagementSystem.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import SpringBootProjects.FlightManagementSystem.Model.FlightFeedback;

@Service
public interface FlightFeedbackService {

	public FlightFeedback addFeedback(FlightFeedback flightFeedback,Integer flightId, Long userId) throws Exception;
		

		public void deleteFeedback(Integer feedbackId) throws Exception;

		public FlightFeedback viewFeedback(Integer flightId) throws Exception;

		public List<FlightFeedback> viewFeedbackAll() throws Exception ;
		
	}

