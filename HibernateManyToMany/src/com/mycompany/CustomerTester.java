package com.mycompany;

import java.util.Set;

public class CustomerTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDao();

		Customer customer = new Customer("Alex", "Sparsiashvili", 7890.9);
		CustomerType customerType = new CustomerType("Best");
		customerDao.saveCustomerType(customerType);
		
		Address address = new Address("USA", "New York", "1234 Kings Highway", "11203");
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
		

	}

}
