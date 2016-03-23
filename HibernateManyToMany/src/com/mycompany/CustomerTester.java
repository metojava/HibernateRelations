package com.mycompany;

import java.util.Set;

public class CustomerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();

		Customer customer = new Customer("Gill", "Gates", 7890.9);
		CustomerType customerType = new CustomerType("Gold");
		customerDao.saveCustomerType(customerType);
		
		Address address = new Address("USA", "New York", "2236 Kings Highway", "11203");
		customer.setCustomerType(customerType);
		customer.getAddresses().add(address);
		try {

		} catch (Exception e) {

			e.printStackTrace();
		}
		long id = customerDao.saveCustomer(customer);
		
		Customer customeri = customerDao.getCustomer(id);
		Set <Address> adresses = customeri.getAddresses();
		if(adresses != null)
			System.out.println(adresses);
		

		Customer customer2 = customerDao.getAllAboutCustomer(id);
		System.out.println(customer2);
		
	}

}
