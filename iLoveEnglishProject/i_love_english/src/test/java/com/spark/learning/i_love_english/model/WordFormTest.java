package com.spark.learning.i_love_english.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordFormTest {
	private SessionFactory sessionFactory;
	@Before
	public void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}

	@After
	public void tearDown() throws Exception {
		if ( sessionFactory != null ) {
			sessionFactory.close();
		}		
	}

	@Test
	public void test() {
		// create a couple of events...
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		WordForm wordForm = new WordForm();
		wordForm.setEntryNo(1);
		wordForm.setHeadLine("first headline");
		wordForm.setLineNo(10);
		session.save( wordForm);
		session.getTransaction().commit();
		session.close();

//		// now lets pull events from the database and list them
//		session = sessionFactory.openSession();
//        session.beginTransaction();
//        List result = session.createQuery( "from Event" ).list();
//		for ( Event event : (List<Event>) result ) {
//			System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
//		}
//        session.getTransaction().commit();
//        session.close();		
	}

}
