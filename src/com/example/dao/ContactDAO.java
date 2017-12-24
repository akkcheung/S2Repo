package com.example.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import com.example.model.Contact;

@RegisterMapper(ContactMapper.class)
public interface ContactDAO {

	@SqlQuery("select contact_id , name, email, address, telephone from contact")
	List <Contact> listAll();
	
	@SqlQuery("select contact_id , name, email, address, telephone from contact where contact_id = :id")
	Contact findById(@Bind("id") int id);
		
	@SqlUpdate("insert into contact (name, email, address, telephone) values (:c.name , :c.email, :c.address, :c.telephone)")
	int insert(@BindBean("c") Contact contact);
	
	@SqlUpdate("update contact set name=:c.name , email=:c.email, address=:c.address, telephone=:c.telephone where contact_id=:c.id")
	int update(@BindBean("c") Contact contact);
	
	@SqlUpdate("delete from contact where contact_id=:id")
	int delete(@Bind("id") int id);
	
	void close();
}
