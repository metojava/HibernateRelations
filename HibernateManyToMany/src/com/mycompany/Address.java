package com.mycompany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@Column
	@GeneratedValue
	long address_id;
	@Column
	String country;
	@Column
	String City;
	@Column
	String Street;
	@Column
	String zip;

	@ManyToMany(mappedBy = "addresses")
	Set<Customer> customers = new HashSet<Customer>();

	public Address() {

	}

	public Address(String country, String city, String street, String zip) {

		this.country = country;
		this.City = city;
		this.Street = street;
		this.zip = zip;
	}

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", country=" + country
				+ ", City=" + City + ", Street=" + Street + ", zip=" + zip
				+ ", customers=" + customers + "]";
	}

}
