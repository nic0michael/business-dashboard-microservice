package za.co.business.dtos;

import java.sql.Timestamp;

import za.co.business.model.Customer;

public class CustomerResponse {


	private String message;
	private String code;
	private Customer customer;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerResponse [message=" + message + ", code=" + code + ", customer=" + customer + "]";
	}
	
	
}
