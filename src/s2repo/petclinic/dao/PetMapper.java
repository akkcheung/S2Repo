package s2repo.petclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import s2repo.petclinic.model.Pet;

public class PetMapper implements ResultSetMapper<Pet>{

	@Override
	public Pet map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		
		Pet pet = new Pet() ;
		
		pet.setId(rs.getInt("id"));
		pet.setName(rs.getString("name"));		
		
		return pet;
	}

}
