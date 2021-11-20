package za.co.business.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_order_id")
	private Long customerOrderId;

	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "product_id")
	private Long productId;
	
	@Column(name = "quantity")
	private Long quantity;
	
	@Column(name = "name", length=256)
	private String name;

	@Column(name = "customer_requirements", length=2048)
	private String customerRequirements;
	
}
