package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier_order")
public class SupplierOrder {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_order_id")
	private Long supplierOrderId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "supplier_id")
	private Long supplierId;
	
	@Column(name = "supplier_name")
	private String supplierName;

	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "name", length=256)
	private String name;
	
	@Column(name = "cost_price")
	private Double costPrice;

	
	


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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}

	public Long getSupplierOrderId() {
		return supplierOrderId;
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

	@Override
	public String toString() {
		return "SupplierOrder [supplierOrderId=" + supplierOrderId + ", dateCreated=" + dateCreated + ", productId="
				+ productId + ", supplierId=" + supplierId + ", supplierName=" + supplierName + ", productName="
				+ productName + ", quantity=" + quantity + ", name=" + name + ", costPrice=" + costPrice + "]";
	}








	
	
}
