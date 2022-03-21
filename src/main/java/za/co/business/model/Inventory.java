package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Long inventoryId;


	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "name", length=256)
	private String name;
	
	@Column(name = "stock_code", length=256)
	private String stockCode;

	@Column(name = "description", length=2048)
	private String description;
	

	@Column(name = "stock_quantity")
	private Double stockQuantity;
	
	@Column(name = "reorder_level")
	private Long reorderLevel;
	
	@Column(name = "economic_order_quantity")
	private Long economicOrderQuantity;	

	@Column(name = "cost_price")
	private Double costPrice;

	
	@Column(name = "supplier_id")
	private Long supplierId;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	

	@Column(name = "supplier_stock_code", length=256)
	private String SupplierstockCode;
	
	
	

	public String getSupplierstockCode() {
		return SupplierstockCode;
	}

	public void setSupplierstockCode(String supplierstockCode) {
		SupplierstockCode = supplierstockCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Double stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public Long getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Long reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Long getEconomicOrderQuantity() {
		return economicOrderQuantity;
	}

	public void setEconomicOrderQuantity(Long economicOrderQuantity) {
		this.economicOrderQuantity = economicOrderQuantity;
	}

	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
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

	public Long getInventoryId() {
		return inventoryId;
	}
	
	

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", dateCreated=" + dateCreated + ", name=" + name
				+ ", stockCode=" + stockCode + ", description=" + description + ", stockQuantity=" + stockQuantity
				+ ", reorderLevel=" + reorderLevel + ", economicOrderQuantity=" + economicOrderQuantity + ", costPrice="
				+ costPrice + ", supplierId=" + supplierId + ", supplierName=" + supplierName + ", SupplierstockCode="
				+ SupplierstockCode + "]";
	}





	
	
	
	
	
	
	

}
