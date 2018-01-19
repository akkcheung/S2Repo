package s2repo.petclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import s2repo.petclinic.model.Owner;
import s2repo.petclinic.model.Pet;
import s2repo.petclinic.model.PetType;

public class PetMapper implements ResultSetMapper<Pet>{

	@Override
	public Pet map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		
		Pet pet = new Pet() ;
		
		pet.setId(rs.getInt("pet_id"));
		pet.setName(rs.getString("pet_name"));				
		pet.setBirthday(rs.getDate("birthday_date"));
		
		if (rs.getInt("owner_id") > 0) {
			Owner owner = new Owner();
			owner.setId(rs.getInt("owner_id"));
			pet.setOwner(owner);
		}
		
		if (rs.getInt("type_id") > 0) {		
			PetType petType = new PetType();
			petType.setId(rs.getInt("type_id"));
			petType.setName(rs.getString("type_name"));
			pet.setType(petType);
		}
		
		return pet;
	}

}
