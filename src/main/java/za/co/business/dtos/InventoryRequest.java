package za.co.business.dtos;

import java.sql.Timestamp;

import javax.persistence.Column;

public class InventoryRequest {
	

	private Long inventoryId;

	private Timestamp dateCreated;

	private String name;

	private String stockCode;

	private String description;

	private Double stockQuantity;

	private Long reorderLevel;

	private Long economicOrderQuantity;	

	private Double costPrice;

	private Double reorderQuantity;	

	private Long supplierId;

	private String supplierName;
	
	private String SupplierstockCode;
	
	
	
	

	public Double getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(Double reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	public String getSupplierstockCode() {
		return SupplierstockCode;
	}

	public void setSupplierstockCode(String supplierstockCode) {
		SupplierstockCode = supplierstockCode;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
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

	@Override
	public String toString() {
		return "InventoryRequest [inventoryId=" + inventoryId + ", dateCreated=" + dateCreated + ", name=" + name
				+ ", stockCode=" + stockCode + ", description=" + description + ", stockQuantity=" + stockQuantity
				+ ", reorderLevel=" + reorderLevel + ", economicOrderQuantity=" + economicOrderQuantity + ", costPrice="
				+ costPrice + ", reorderQuantity=" + reorderQuantity + ", supplierId=" + supplierId + ", supplierName="
				+ supplierName + ", SupplierstockCode=" + SupplierstockCode + "]";
	}






	
	

}
