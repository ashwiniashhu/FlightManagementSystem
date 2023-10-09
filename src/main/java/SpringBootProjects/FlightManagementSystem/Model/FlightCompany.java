package SpringBootProjects.FlightManagementSystem.Model;

import java.sql.Date;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="company_details")
@DynamicUpdate
public class FlightCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_id",nullable=false,unique=true)
	private Integer companyId;
	
	@Column(name="company_name",nullable=false,updatable=true,length=50)
	private String companyName;

	@Column(name="founder_name",nullable=false,updatable=true,length=100)
	private String founderName;
	
	@Column(name="year_of_establishing",nullable=false)
	private String establishedYear;
	
	@Column(name="year_of_service")
    private Integer yearsOfService;

	public String getFounderName() {
		return founderName;
	}

	public void setFounderName(String founderName) {
		this.founderName = founderName;
	}

	
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	

	public String getEstablishedYear() {
		return establishedYear;
	}

	public void setEstablishedYear(String establishedYear) {
		this.establishedYear = establishedYear;
	}

	public Integer getYearsOfService() {
		return yearsOfService;
	}

	public void setYearsOfService(Integer yearsOfService) {
		this.yearsOfService = yearsOfService;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", founderName=" + founderName
				+ ", establishedYear=" + establishedYear + ", yearsOfService=" + yearsOfService + "]";
	}

	
	
}
