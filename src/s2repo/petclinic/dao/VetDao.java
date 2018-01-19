package s2repo.petclinic.dao;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import s2repo.petclinic.model.Owner;
import s2repo.petclinic.model.Pet;
import s2repo.petclinic.model.PetType;
import s2repo.petclinic.model.Vet;

@RegisterMapper(VetMapper.class)
public interface VetDao {

//	@SqlQuery("select v.id vet_id, first_name, last_name, s.id speciality_id, s.name speciality_name from vets as v"
//			+ " inner join vet_specialties as vm on v.id = vm.vet_id"
//			+ " inner join specialties as s on vm.speciality_id = s.id"
//			+ " order by v.id")
//	List <Vet> listAll();
	
	@SqlQuery("select v.id vet_id, first_name, last_name "
			+ " ,s.id specialty_id, s.name specialty_name "
			+ " from vets as v"
			+ " inner join vet_specialties as vs on v.id = vs.vet_id"
			+ " inner join specialties as s on vs.specialty_id = s.id"
			+ " where"
			+ " last_name like :last_name"
			+ " and" 
			+ " s.id >0"
			+ " order by v.id")
	List <Vet> search(@Bind("last_name") String last_name);
		
	void close();
}
