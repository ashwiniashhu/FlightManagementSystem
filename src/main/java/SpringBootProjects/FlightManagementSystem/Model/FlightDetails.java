package SpringBootProjects.FlightManagementSystem.Model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
//It specifies that the class is an entity and is mapped to a database table
@Entity
@Table(name="Flight_Details")
@DynamicUpdate
public class FlightDetails {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="record_no")
		private Integer flightId;
		
		@Column(name="domestic_flight")
		private Boolean isDomestic;

		@Column(name="flight_number" , length=6)
		private String flightNumber;
		
		@Column(name="flight_name", length=20)
		private String flightName;
		

		private String source;
		
		private String destination;
				
		@Column(name="ticket_cost")
		private Integer ticketCost;
		
		@Column(name="flight_rating")
		private Integer rating;
		
		@Column(name="class_of_journey")
		private String classOfJourney;
		//Economy,Basic_Economy,Premium_Economy,Business,First
		
		@Column(name="duration")
		private String duration;
		
		@Column(name="cancellation_cost")
		private Integer cancellationCost;
		
		
		public Integer getCancellationCost() {
			return cancellationCost;
		}


		public void setCancellationCost(Integer cancellationCost) {
			this.cancellationCost = cancellationCost;
		}


		public String getDuration() {
			return duration;
		}


		public void setDuration(String duration) {
			this.duration = duration;
		}


		public String getClassOfJourney() {
			return classOfJourney;
		}


		public void setClassOfJourney(String classOfJourney) {
			this.classOfJourney = classOfJourney;
		}


		public Integer getRating() {
			return rating;
		}


		public void setRating(Integer rating) {
			this.rating = rating;
		}


		public int getFlightId() {
			return flightId;
		}


		public void setFlightId(int flightId) {
			this.flightId = flightId;
		}


		public String getFlightNumber() {
			return flightNumber;
		}


		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}


		public String getFlightName() {
			return flightName;
		}


		public void setFlightName(String flightName) {
			this.flightName = flightName;
		}


		
		
		public String getSource() {
			return source;
		}


		public void setSource(String source) {
			this.source = source;
		}


		public String getDestination() {
			return destination;
		}


		public void setDestination(String destination) {
			this.destination = destination;
		}


		public Integer getTicketCost() {
			return ticketCost;
		}


		public void setTicketCost(Integer ticketCost) {
			this.ticketCost = ticketCost;
		}


		public Boolean getIsDomestic() {
			return isDomestic;
		}


		public void setIsDomestic(Boolean isDomestic) {
			this.isDomestic = isDomestic;
		}


		@Override
		public String toString() {
			return "FlightDetails [flightId=" + flightId + ", isDomestic=" + isDomestic + ", flightNumber="
					+ flightNumber + ", flightName=" + flightName + ", source=" + source + ", destination="
					+ destination + ", ticketCost=" + ticketCost + ", rating=" + rating + ", classOfJourney="
					+ classOfJourney + ", duration=" + duration + ", cancellationCost=" + cancellationCost + "]";
		}


		
		

		
		
}

		



