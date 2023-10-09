package SpringBootProjects.FlightManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProjects.FlightManagementSystem.Model.Airport;
import SpringBootProjects.FlightManagementSystem.Model.FlightCompany;

@Repository
public interface AirportRepository extends JpaRepository<Airport,Integer>{ 

	List<Airport> findByAirportNameContainingIgnoreCase(String airportName);


	
}