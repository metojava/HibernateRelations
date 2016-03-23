package com.mycompany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({

		@NamedQuery(name = "Customer.getAllData", query = "select distinct c from Customer c  left  join fetch c.addresses a left join fetch c.customerType t"),
		@NamedQuery(name = "Customer.getCustomerWithDetails", query = "select distinct c from Customer c  left  join fetch c.addresses a left join fetch c.customerType t where c.customer_id = :id") })
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@Column
	@GeneratedValue
	Long customer_id;
	@Column
	String firstName;
	@Column
	String lastName;
	@Column
	double salary;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "CUSTOMER_ADDRESS", joinColumns = { @JoinColumn(name = "CUSTOMER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	Set<Address> addresses = new HashSet<Address>();

	@ManyToOne
	@JoinColumn(name = "customerType_Id")
	private CustomerType customerType;

	public Customer() {

	}

	public Customer(String firstName, String lastName, double salary) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", salary=" + salary
				+ "]";
	}

}
