package SpringBootProjects.FlightManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import SpringBootProjects.FlightManagementSystem.Model.FlightCompany;

@Repository
public interface FlightCompanyRepository extends JpaRepository<FlightCompany,Integer>{
	
	List<FlightCompany> findByCompanyNameContainingIgnoreCase(String companyName);

}
