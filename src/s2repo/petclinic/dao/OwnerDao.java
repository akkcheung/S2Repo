package s2repo.petclinic.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import s2repo.petclinic.model.Owner;

@RegisterMapper(OwnerMapper.class)
public interface OwnerDao {

	@SqlQuery("select id , first_name, last_name city, telephone, address from owners")
	List <Owner> listAll();
	
	@SqlQuery("select id , first_name, last_name, city, telephone, address from owners where id = :id")
	Owner findById(@Bind("id") int id);
	
	
	@SqlQuery("select id , first_name, last_name, city, telephone, address from owners where last_name like :last_name")
	List <Owner> search(@Bind("last_name") String last_name);
	
//	@SqlQuery("select id , first_name, last_name from owners limit :limit offset :offset")
//	List <Pet> getPersonPage(@Bind("offset") int offset, @Bind("limit") int limit );
//
//	@SqlQuery("SELECT COUNT(*) FROM owners")
//	int getPersonCount();
	
//	@SqlUpdate("insert into owners (first_name, last_name, city, telephone, address) values (:first_name , :last_name, :city, :telephone, :address")
//	int insert(@Bind("first_name") String first_name, @Bind("last_name") String last_name, @Bind("city") String city, @Bind("telephone") String telephone, @Bind("address") String address);
	
	@SqlUpdate("insert into owners (first_name, last_name, city, telephone, address) values (:o.firstName , :o.lastName, :o.city, :o.telephone, :o.address)")
	int insert(@BindBean("o") Owner owner);
	
	@SqlUpdate("update owners set first_name=:o.firstName , last_name=:o.lastName, city=:o.city, telephone=:o.telephone, address=:o.address where id=:o.id")
	int update(@BindBean("o") Owner owner);
	
	void close();
}
