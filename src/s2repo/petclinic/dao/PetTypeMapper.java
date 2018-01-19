package s2repo.petclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import s2repo.petclinic.model.PetType;

public class PetTypeMapper implements ResultSetMapper<PetType> {

	@Override
	public PetType map(int index, ResultSet rs, StatementContext ctx) throws SQLException {

		PetType petType = new PetType() ;
		
		petType.setId(rs.getInt("id"));
		petType.setName(rs.getString("name"));	
		
		return petType;
	}

}
