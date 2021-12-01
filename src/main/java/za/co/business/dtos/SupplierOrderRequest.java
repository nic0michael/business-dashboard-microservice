package za.co.business.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SupplierOrderRequest {


	private Long supplierOrderId;
	private Timestamp dateCreated;
	private Long productId;
	private String productName;
	private Long supplierId;
	private String supplierName;
	private Long quantity;
	private String name;
	private Double costPrice;
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Long getSupplierOrderId() {
		return supplierOrderId;
	}
	public void setSupplierOrderId(Long supplierOrderId) {
		this.supplierOrderId = supplierOrderId;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
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
	public Double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	@Override
	public String toString() {
		return "SupplierOrderRequest [supplierOrderId=" + supplierOrderId + ", dateCreated=" + dateCreated
				+ ", productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", supplierName=" + supplierName + ", quantity=" + quantity + ", name=" + name + ", costPrice="
				+ costPrice + "]";
	}


	
	

}
