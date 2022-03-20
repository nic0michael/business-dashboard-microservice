package za.co.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_inventory")
public class ProductInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_inventory_id")
	private Long productInventoryId;
	

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "inventory_id")
	private Long inventoryId;
	
	@Column(name = "product_quantity")
	private Long productQuantity;
	
	@Column(name = "inventory_stock_quantity")
	private Double inventoryStockQuantity;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Double getInventoryStockQuantity() {
		return inventoryStockQuantity;
	}

	public void setInventoryStockQuantity(Double inventoryStockQuantity) {
		this.inventoryStockQuantity = inventoryStockQuantity;
	}

	public Long getProductInventoryId() {
		return productInventoryId;
	}

	@Override
	public String toString() {
		return "ProductInventory [productInventoryId=" + productInventoryId + ", productId=" + productId
				+ ", inventoryId=" + inventoryId + ", inventoryStockQuantity=" + inventoryStockQuantity + "]";
	}

	
	
}
