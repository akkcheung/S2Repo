package s2repo.petclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import s2repo.petclinic.model.Pet;
import s2repo.petclinic.model.PetType;
import s2repo.petclinic.model.Visit;

public class VisitMapper implements ResultSetMapper<Visit> {

	@Override
	public Visit map(int index, ResultSet rs, StatementContext ctx) throws SQLException {

		Visit visit = new Visit() ;
		
		visit.setId(rs.getInt("id"));
		visit.setDescription(rs.getString("description"));
		visit.setDate(rs.getDate("visit_date"));
		
		if (rs.getInt("pet_id") > 0) {		
			Pet pet = new Pet();
			pet.setId(rs.getInt("pet_id"));
	
		}		
		
		return visit;
	}

}
