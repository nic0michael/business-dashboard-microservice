package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "date_created")
	private Timestamp dateCreated;

	@Column(name = "name", length=256)
	private String name;
	
	@Column(name = "product_code", length=256)
	private String productCode;

	@Column(name = "description", length=2048)
	private String description;
	
	@Column(name = "supplier_id")
	private Long supplierId;
	
	@Column(name = "supplier_name")
	private String supplierName;
	
	@Column(name = "file_image_id")
	private Long FileImageId;
	
	@Column(name = "stock_quantity")
	private Long stockQuantity;
	
	@Column(name = "reorder_level")
	private Long reorderLevel;
	
	@Column(name = "economic_order_quantity")
	private Long economicOrderQuantity;	

	@Column(name = "cost_price")
	private Double costPrice;
	
	@Column(name = "selling_price")
	private Double sellingPrice;

	
	
	
	
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getFileImageId() {
		return FileImageId;
	}

	public void setFileImageId(Long fileImageId) {
		FileImageId = fileImageId;
	}

	public Long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
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

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Long getProductId() {
		return productId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", dateCreated=" + dateCreated + ", name=" + name + ", productCode="
				+ productCode + ", description=" + description + ", supplierId=" + supplierId + ", supplierName="
				+ supplierName + ", FileImageId=" + FileImageId + ", stockQuantity=" + stockQuantity + ", reorderLevel="
				+ reorderLevel + ", economicOrderQuantity=" + economicOrderQuantity + ", costPrice=" + costPrice
				+ ", sellingPrice=" + sellingPrice + "]";
	}


	

}
