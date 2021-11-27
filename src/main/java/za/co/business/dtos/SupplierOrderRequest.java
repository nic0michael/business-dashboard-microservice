package za.co.business.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SupplierOrderRequest {


	private Long supplierOrderId;
	private Timestamp dateCreated;
	private Long supplierId;
	private Long productId;
	private Long quantity;
	private String name;
	private Double costPrice;
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
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
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
				+ ", supplierId=" + supplierId + ", productId=" + productId + ", quantity=" + quantity + ", name="
				+ name + ", costPrice=" + costPrice + "]";
	}	

}
