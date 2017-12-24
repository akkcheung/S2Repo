package com.example.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.skife.jdbi.v2.DBI;

import com.example.dao.ContactDAO;
import com.example.model.Contact;
import com.example.util.DataSourceFactory;
import com.opensymphony.xwork2.ActionSupport;

public class HomeController extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Contact> listContact ;
	
	private Contact contact;
	
	private int id ;
	
	public String listContact() {
		DBI dbi = new DBI(DataSourceFactory.getH2DataSource());		
		ContactDAO dao = dbi.onDemand(ContactDAO.class);
		this.listContact = dao.listAll();

		return SUCCESS;
	}
	
	public String newContact() {
		this.contact = new Contact();
		
		return SUCCESS;
	}
	
	public String saveContact() {
		DBI dbi = new DBI(DataSourceFactory.getH2DataSource());
		ContactDAO dao = dbi.onDemand(ContactDAO.class);
		
		if (contact.getId() > 0)
			dao.update(contact);
		else
			dao.insert(contact);
		
		return SUCCESS;
	}
	
	public String deleteContact() {
		DBI dbi = new DBI(DataSourceFactory.getH2DataSource());
		ContactDAO dao = dbi.onDemand(ContactDAO.class);
		dao.delete(id);
		
		return SUCCESS;
	}
	
	public String editContact() {
		DBI dbi = new DBI(DataSourceFactory.getH2DataSource());
		ContactDAO dao = dbi.onDemand(ContactDAO.class);
		
		
		Logger.getLogger(HomeController.class.getName()).log(Level.INFO, "id->" + id, "");
		this.contact = dao.findById(id);
		
		return SUCCESS;
	}

	public List<Contact> getListContact() {
		return listContact;
	}

	public void setListContact(List<Contact> listContact) {
		this.listContact = listContact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
