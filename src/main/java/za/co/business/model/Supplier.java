package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private Long supplierId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "name", length=256)
	private String name;

	@Column(name = "contact_name", length=256)
	private String contactName;
	
	@Column(name = "physical_address", length=256)
	private String physicalAddress;
	
	@Column(name = "postal_address", length=256)
	private String postalAddress;
	
	@Column(name = "email_address", length=128)
	private String emailAddress;
	
	@Column(name = "phone", length=128)
	private String Phone;
	
	@Column(name = "cell_phone", length=128)
	private String cellPhone;
	
	

	public Long getSupplierId() {
		return supplierId;
	}

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

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", dateCreated=" + dateCreated + ", name=" + name
				+ ", contactName=" + contactName + ", physicalAddress=" + physicalAddress + ", postalAddress="
				+ postalAddress + ", emailAddress=" + emailAddress + ", Phone=" + Phone + ", cellPhone=" + cellPhone
				+ "]";
	}
	
	
}
