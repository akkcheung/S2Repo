package s2repo.petclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import s2repo.petclinic.model.PetType;
import s2repo.petclinic.model.Specialty;
import s2repo.petclinic.model.Vet;

public class VetMapper implements ResultSetMapper<Vet> {

	@Override
	public Vet map(int index, ResultSet rs, StatementContext ctx) throws SQLException {

		Vet vet = new Vet() ;
		
		vet.setId(rs.getInt("vet_id"));
		vet.setFirstName(rs.getString("first_name"));	
		vet.setLastName(rs.getString("last_name"));		
		
		if (rs.getInt("specialty_id") > 0) {
			Specialty specialty = new Specialty();
			
			specialty.setId(rs.getInt("specialty_id"));
			specialty.setName(rs.getString("name"));
			
			vet.addSpecialty(specialty);
		}
		
		
		
		return vet;
	}

}
