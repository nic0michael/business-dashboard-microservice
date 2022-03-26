package za.co.business.dtos;

import java.sql.Timestamp;

import org.springframework.lang.NonNull;

public class ConfigurationRequest {

	
	private Long configurationId;
	
	private Timestamp dateCreated;
	
	private String companyName;
	
	private String branchName;

	private String branchPhone;

	private String industry;
	
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
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Long getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(Long configurationId) {
		this.configurationId = configurationId;
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

	@Override
	public String toString() {
		return "ConfigurationRequest [configurationId=" + configurationId + ", dateCreated=" + dateCreated
				+ ", companyName=" + companyName + ", branchName=" + branchName + ", branchPhone=" + branchPhone
				+ ", industry=" + industry + ", discount=" + discount + ", email=" + email + ", enabled=" + enabled
				+ "]";
	}



	
	
}
