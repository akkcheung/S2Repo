package s2repo.petclinic.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import s2repo.petclinic.model.PetType;

@RegisterMapper(PetTypeMapper.class)
public interface PetTypeDao {

	@SqlQuery("select id , name from types")
	List <PetType> listAll();
	 	
	void close();
}
