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
import s2repo.petclinic.model.Visit;

@RegisterMapper(VisitMapper.class)
public interface VisitDao {

	@SqlQuery("select id, visit_date, description, p.id,  pet_name, birthday_date, type_id, owner_id, t.name type_name from visits as v, pets as p, types as t where v.pet_id = p.id and p.type_id = t.id")
	List <Visit> listAll();	
	 		
	@SqlQuery("select id, visit_date, description, pet_id from visits as v where pet_id=:petId order by visit_date")
	List <Visit> listByPetId(@Bind("petId") int petId);
	
	@SqlQuery("select id, visit_date, description, pet_id from visits as v where v.id =:visitId ")
	Visit findById(@Bind("visitId") int visitId);
	
	
	@SqlUpdate("insert into visits (visit_date, description, pet_id) values "
			+ "(:visitDate , :description, :petId )")
	int insert(@Bind("visitDate") Date visitDate, @Bind("description") String description,  @Bind("petId") int petId);
		
	@SqlUpdate("update visits set visit_date=:visitDate, description=:description, pet_id=:petId where id=:id")
	int update(@Bind("visitDate") Date visitDate, @Bind("description") String description, @Bind("petId") int petId, @Bind("id") int id );	
	
	void close();
}
