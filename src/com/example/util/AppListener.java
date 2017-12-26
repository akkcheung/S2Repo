package com.example.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.data.ContactDB;
import s2repo.petclinic.data.PetClinicDB;

public class AppListener implements ServletContextListener {
	;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		ServletContext sc = sce.getServletContext();

		// Create and populate the embedded H2 database.
		ContactDB.createPopulateH2();

		// Retreive products from database and place into ServletContext.
		// List<Product> products = ProductDB.createList();
		// sc.setAttribute("products", products);

		PetClinicDB.createPopulateH2();
		
	}

}
