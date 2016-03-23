package com.mycompany;

import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CustomerDao {

	private SessionFactory sessionFactory;

	public CustomerDao() {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Long saveCustomer(Customer customer) {
		Long savedId = null;
		Transaction tx = null;
		try {
			Session session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			savedId = (Long) session.save(customer);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return savedId;
	}

	public Long saveCustomerType(CustomerType customerType) {
		Long savedId = null;
		Transaction tx = null;
		try {
			Session session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			savedId = (Long) session.save(customerType);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return savedId;
	}

	public Customer getCustomer(long id) {
		Customer customer = null;
		Transaction tx = null;
		try {
			Session session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			customer = (Customer) session.get(Customer.class, id);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return customer;
	}

	public Customer getAllAboutCustomer(long id) {
		Customer customer = null;
		Transaction tx = null;
		try {
			Session session = getSessionFactory().openSession();
			tx = session.beginTransaction();
			customer = (Customer)session.getNamedQuery("Customer.getCustomerWithDetails")
					.setParameter("id", id).uniqueResult();

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return customer;
	}

}
