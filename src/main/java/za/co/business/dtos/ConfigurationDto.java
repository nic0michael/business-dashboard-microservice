package za.co.business.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class ConfigurationDto {
	
	private Long configurationId;
	
	private Timestamp dateCreated;
	
	private String companyName;
	
	private String branchName;

	private String branchPhone;

	private String industry;
	
	private Double discount;

	
	
	
	
	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getConfigurationId() {
		return configurationId;
	}

	public void setConfigurationId(Long configurationId) {
		this.configurationId = configurationId;
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
		return "ConfigurationDto [configurationId=" + configurationId + ", dateCreated=" + dateCreated
				+ ", companyName=" + companyName + ", branchName=" + branchName + ", branchPhone=" + branchPhone
				+ ", industry=" + industry + ", discount=" + discount + "]";
	}


	
	

}
