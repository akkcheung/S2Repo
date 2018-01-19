package s2repo.petclinic.dao;

import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import s2repo.petclinic.model.Owner;
import s2repo.petclinic.model.Pet;

@RegisterMapper(PetMapper.class)
public interface PetDao {

	@SqlQuery("select p.id  id, p.name pet_name, birthday_date, type_id, owner_id, t.name type_name from pets as p, types as t where p.type_id = t.id")
	List <Pet> listAll();	
	 	
	@SqlQuery("select id , name, birthday_date, type_id, owner_id from pets limit :limit offset :offset")
	List <Pet> getPage(@Bind("offset") int offset, @Bind("limit") int limit );

	@SqlQuery("SELECT COUNT(*) FROM pet")
	int getPersonCount();
	
	@SqlQuery("select p.id pet_id , p.name pet_name, birthday_date, type_id, owner_id, t.name type_name from pets as p, types as t where owner_id=:ownerId and type_id = t.id order by p.name")
	List <Pet> listByOwnerId(@Bind("ownerId") int ownerId);
	
	@SqlQuery("select p.id pet_id , p.name pet_name, birthday_date, type_id, owner_id, t.name type_name from pets as p, types as t where p.id =:petId ")
	Pet findById(@Bind("petId") int petId);
	
	
	@SqlUpdate("insert into pets (name, birthday_date, type_id, owner_id) values "
			+ "(:name , :birthday, :typeId, :ownerId )")
	int insert(@Bind("name") String name, @Bind("birthday") Date birthday, @Bind("typeId") int typeId, @Bind("ownerId") int ownerId );
		
	@SqlUpdate("update pets set name=:name , birthday_date=:birthday, type_id=:typeId where id=:id")
	int update(@Bind("name") String name, @Bind("birthday") Date birthday, @Bind("typeId") int typeId, @Bind("id") int id );
	
	
	void close();
}
