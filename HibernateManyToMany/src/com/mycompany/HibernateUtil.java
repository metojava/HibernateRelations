package com.mycompany;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static  SessionFactory sessionFactory;

	private static SessionFactory createSessionFactory() {
		if (sessionFactory == null) {
			synchronized (HibernateUtil.class) {
				if (sessionFactory == null) {
					sessionFactory = new AnnotationConfiguration().configure()
							.buildSessionFactory();
				}
			}
		}
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory()
	{
		return createSessionFactory();
	}
}
