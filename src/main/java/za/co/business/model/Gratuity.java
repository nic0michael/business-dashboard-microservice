package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gratuity")
public class Gratuity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gratuity_id")
	private Long gratuityId;

	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	@Column(name = "comments", length=256)
	private String comments;
	


	@Column(name = "gratuity_paid")
	private Double gratuityPaid;

	
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "employee_fullname", length=256)
	private String employeeFullname;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "customer_name", length=256)
	private String customerName;

	@Column(name = "nr_of_orders_not_paid")
	private Integer nrOfOrdersNotPaid;	
	
	
	
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getNrOfOrdersNotPaid() {
		return nrOfOrdersNotPaid;
	}

	public void setNrOfOrdersNotPaid(Integer nrOfOrdersNotPaid) {
		this.nrOfOrdersNotPaid = nrOfOrdersNotPaid;
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

	public Long getGratuityId() {
		return gratuityId;
	}

	@Override
	public String toString() {
		return "Gratuity [gratuityId=" + gratuityId + ", dateCreated=" + dateCreated + ", comments=" + comments
				+ ", gratuityPaid=" + gratuityPaid + ", employeeId=" + employeeId + ", employeeFullname="
				+ employeeFullname + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", nrOfOrdersNotPaid=" + nrOfOrdersNotPaid + "]";
	}


	
	
	




	
	
	
	












	
	
}
