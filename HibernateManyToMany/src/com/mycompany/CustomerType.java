package com.mycompany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CustomerType")
public class CustomerType {

	@Id
	@Column
	@GeneratedValue
	long customerType_Id;

	@Column
	String type;
	
	@OneToMany(mappedBy="customerType")
	Set<Customer>customers = new HashSet<Customer>();
	
	public CustomerType( String type) {
		this.type = type;
	}

	public CustomerType() {

	}

	public long getCustomerType_Id() {
		return customerType_Id;
	}

	public void setCustomerType_Id(long customerType_Id) {
		this.customerType_Id = customerType_Id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "CustomerType [customerType_Id=" + customerType_Id + ", type="
				+ type + ", customers=" + customers + "]";
	}

	
}
