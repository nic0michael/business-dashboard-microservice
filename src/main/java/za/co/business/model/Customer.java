package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "name", length=256)
	private String name; 
	
	@Column(name = "credits")
	private Long credits;
	
	@Column(name = "delivery_address", length=256)
	private String deliveryAddress;
	
	@Column(name = "invoice_address", length=256)
	private String invoiceAddress;
	
	@Column(name = "email_address", length=128)
	private String emailAddress;
	
	@Column(name = "cell_phone", length=128)
	private String cellPhone;

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public Long getCredits() {
		return credits;
	}

	public void setCredits(Long credits) {
		this.credits = credits;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getInvoiceAddress() {
		return invoiceAddress;
	}

	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", dateCreated=" + dateCreated + ", name=" + name + ", credits="
				+ credits + ", deliveryAddress=" + deliveryAddress + ", invoiceAddress=" + invoiceAddress
				+ ", emailAddress=" + emailAddress + ", cellPhone=" + cellPhone + "]";
	}





	
	
	
}
