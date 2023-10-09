package SpringBootProjects.FlightManagementSystem.Model;

import org.hibernate.annotations.DynamicUpdate;

import java.util.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Airport_details")
@DynamicUpdate
public class Airport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sirport_id",nullable=false,unique=true)
	private Integer airportId;
	
	@Column(name="airport_code",nullable=false,unique=true,length=30)
	private String airportCode;
	
	@Column(name="airport_name",nullable=false,updatable=true,length=50)
	private String airportName;
	
	@Column(name="airport_city",nullable=false,updatable=true,length=60)
	private String airportCity;
	
	@Column(name="airport_country",nullable=false,length=50)
	private String airportCountry;
	
	
	
	public Integer getAirportId() {
		return airportId;
	}

	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getAirportCity() {
		return airportCity;
	}

	public void setAirportCity(String airportCity) {
		this.airportCity = airportCity;
	}

	public String getAirportCountry() {
		return airportCountry;
	}

	public void setAirportCountry(String airportCountry) {
		this.airportCountry = airportCountry;
	}

	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportCode=" + airportCode + ", airportName=" + airportName
				+ ", airportCity=" + airportCity + ", airportCountry=" + airportCountry + "]";
	}
	
	

}
