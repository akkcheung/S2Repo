package com.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.example.model.Contact;

public class ContactMapper implements ResultSetMapper<Contact>{

	@Override
	public Contact map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		
		Contact contact = new Contact() ;
		
		contact.setId(rs.getInt("contact_id"));
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress(rs.getString("address"));
		contact.setTelephone(rs.getString("telephone"));

		
		return contact;
	}

}
