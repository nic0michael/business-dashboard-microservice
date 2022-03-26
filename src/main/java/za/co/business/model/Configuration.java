package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "configuration")
public class Configuration {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long configurationId;

	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	@NotBlank
    @Column(name="company_name", unique=true)
	private String companyName="Company Name";
	
    @Column(name="branch_name")
	private String branchName;

    @Column(name="branch_phone")
	private String branchPhone;

    @Column(name="industry")
	private String industry;
    
    @Column(name="discount")
	private Double discount;
    
	
	private String email;


	private Integer enabled;

    
    
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEnabled() {
		if(enabled==null) {
			return 0;
		} else {
			return enabled;
		}
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchPhone() {
		return branchPhone;
	}

	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Long getConfigurationId() {
		return configurationId;
	}

	@Override
	public String toString() {
		return "Configuration [configurationId=" + configurationId + ", dateCreated=" + dateCreated + ", companyName="
				+ companyName + ", branchName=" + branchName + ", branchPhone=" + branchPhone + ", industry=" + industry
				+ ", discount=" + discount + ", email=" + email + ", enabled=" + enabled + "]";
	}



    

}
