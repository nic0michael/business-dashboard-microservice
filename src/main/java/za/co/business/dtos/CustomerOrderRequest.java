package za.co.business.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class CustomerOrderRequest {

	private Long customerOrderId;
	private Timestamp dateCreated;
	private Long customerId;
	private Long productId;
	private Long quantity;
	private String name;
	private String customerRequirements;
	private Double sellingPrice;
	
	public Long getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(Long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomerRequirements() {
		return customerRequirements;
	}
	public void setCustomerRequirements(String customerRequirements) {
		this.customerRequirements = customerRequirements;
	}
	public Double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	@Override
	public String toString() {
		return "CustomerOrderRequest [customerOrderId=" + customerOrderId + ", dateCreated=" + dateCreated
				+ ", customerId=" + customerId + ", productId=" + productId + ", quantity=" + quantity + ", name="
				+ name + ", customerRequirements=" + customerRequirements + ", sellingPrice=" + sellingPrice + "]";
	}
	

}
