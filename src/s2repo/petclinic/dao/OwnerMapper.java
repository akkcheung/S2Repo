package s2repo.petclinic.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import s2repo.petclinic.model.Owner;

public class OwnerMapper implements ResultSetMapper<Owner>{

	@Override
	public Owner map(int index, ResultSet rs, StatementContext ctx) throws SQLException {
		// TODO Auto-generated method stub
		
		Owner owner = new Owner() ;
		
		owner.setId(rs.getInt("id"));
		owner.setFirstName(rs.getString("first_name"));
		owner.setLastName(rs.getString("last_name"));
		owner.setCity(rs.getString("city"));
		owner.setTelephone(rs.getString("telephone"));
		owner.setAddress(rs.getString("address"));
		
		return owner;
	}

}
