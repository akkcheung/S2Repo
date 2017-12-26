package s2repo.petclinic.util;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;

public class DataSourceFactory {

	public static DataSource getH2PetClinicDataSource() {
		return JdbcConnectionPool.create(
					"jdbc:h2:mem:petclinicdb;DB_CLOSE_DELAY=-1", "user", "password");
		
	}
}
