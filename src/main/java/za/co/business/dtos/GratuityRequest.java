package za.co.business.dtos;

import java.sql.Timestamp;

public class GratuityRequest {
	

	private Long gratuityId;
	private Timestamp dateCreated;
	private Double gratuityPaid;
	private Long employeeId;
	private String employeeFullname;
	private Long customerId;
	private String customerName;
	private Integer nrOfOrdersNotPaid;
	private String comments;
	
	
	
	public Integer getNrOfOrdersNotPaid() {
		return nrOfOrdersNotPaid;
	}

	public void setNrOfOrdersNotPaid(Integer nrOfOrdersNotPaid) {
		this.nrOfOrdersNotPaid = nrOfOrdersNotPaid;
	}

	public Long getGratuityId() {
		return gratuityId;
	}
	
	public void setGratuityId(Long gratuityId) {
		this.gratuityId = gratuityId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Double getGratuityPaid() {
		return gratuityPaid;
	}
	public void setGratuityPaid(Double gratuityPaid) {
		this.gratuityPaid = gratuityPaid;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeFullname() {
		return employeeFullname;
	}
	public void setEmployeeFullname(String employeeFullname) {
		this.employeeFullname = employeeFullname;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "GratuityRequest [gratuityId=" + gratuityId + ", dateCreated=" + dateCreated + ", gratuityPaid="
				+ gratuityPaid + ", employeeId=" + employeeId + ", employeeFullname=" + employeeFullname
				+ ", customerId=" + customerId + ", customerName=" + customerName + ", nrOfOrdersNotPaid="
				+ nrOfOrdersNotPaid + ", comments=" + comments + "]";
	}

	
	
	

	

}
