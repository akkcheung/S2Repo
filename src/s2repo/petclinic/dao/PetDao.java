package s2repo.petclinic.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import s2repo.petclinic.model.Pet;

@RegisterMapper(PetMapper.class)
public interface PetDao {

	@SqlQuery("select id , name from pet")
	List <Pet> listAll();
	 
	@SqlQuery("select id , first_name, last_name from person limit :limit offset :offset")
	List <Pet> getPersonPage(@Bind("offset") int offset, @Bind("limit") int limit );

	@SqlQuery("SELECT COUNT(*) FROM person")
	int getPersonCount();
	
	void close();
}
