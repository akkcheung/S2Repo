package s2repo.petclinic.data;

import java.sql.Connection;
import java.sql.SQLException;

public class PetClinicDB {

	public static void createPopulateH2() {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();

		System.out.println(conn.toString());
		
		final String createVetsTbl = "DROP TABLE IF EXISTS vets ;" 
		+ "CREATE TABLE vets (" 
		+ "`id` int(11) NOT NULL AUTO_INCREMENT," 
		+ "`first_name` varchar(30) ,"
		+ "`last_name` varchar(30) ,"  
		+ "PRIMARY KEY (id));" ;
				
		final String createSpecialtiesTbl= "DROP TABLE IF EXISTS specialties ;" 
				+ "CREATE TABLE specialties (" 
				+ "`id` int(11) NOT NULL AUTO_INCREMENT," 
				+ "`name` varchar(80) ,"  
				+ "PRIMARY KEY (id));" ;
		
		final String createVetSpecialtiesTbl= "DROP TABLE IF EXISTS vet_specialties ;" 
				+ "CREATE TABLE vet_specialties (" 
				+ "`vet_id` int(11) NOT NULL ,"
				+ "`specialty_id` int(11) NOT NULL)";
		
		final String alterVetSpecialtiesTbl = "Alter Table vet_specialties add constraint unique(vet_id, specialty_id)";
		
		final String createTypesTbl = "DROP TABLE IF EXISTS `types` ;" 
				+ "CREATE TABLE `types` (" 
				+ "`id` int(11) NOT NULL AUTO_INCREMENT," 
				+ "`name` varchar(80) ,"  
				+ "PRIMARY KEY (id));" ;
		
		final String createOwnersTbl = "DROP TABLE IF EXISTS owners ;" 
				+ "CREATE TABLE owners (" 
				+ "`id` int(11) NOT NULL AUTO_INCREMENT," 
				+ "`first_name` varchar(30) ,"
				+ "`last_name` varchar(30) ,"  
				+ "`address` varchar(255) ,"
				+ "`city` varchar(80), "
				+ "`telephone` varchar(20) ,"
				+ "PRIMARY KEY (id));" ;
		
		final String createPetsTbl = "DROP TABLE IF EXISTS pets ;" 
				+ "CREATE TABLE pets (" 
				+ "`id` int(11) NOT NULL AUTO_INCREMENT," 
				+ "`name` varchar(30) ,"
				+ "`birthday_date` date,"
				+ "`type_id` int(11) ,"  
				+ "`owner_id` int(11) ,"		
				+ "PRIMARY KEY (id));" ;
		
		final String createVisitsTbl = "DROP TABLE IF EXISTS visits ;" 
				+ "CREATE TABLE visits (" 
				+ "`id` int(11) NOT NULL AUTO_INCREMENT," 
				+ "`pet_id` int(11) ,"
				+ "`visit_date` date ,"  
				+ "`description` varchar(255) ,"
				+ "PRIMARY KEY (id));" ;
		
		
		final String populateVetsTbl = 
				"INSERT INTO vets VALUES (1, 'James', 'Carter');"
				+ " INSERT  INTO vets VALUES (2, 'Helen', 'Leary');" 
				+ " INSERT  INTO vets VALUES (3, 'Linda', 'Douglas');"
				+ " INSERT  INTO vets VALUES (4, 'Rafael', 'Ortega');"
				+ " INSERT  INTO vets VALUES (5, 'Henry', 'Stevens');"
				+ " INSERT  INTO vets VALUES (6, 'Sharon', 'Jenkins');" ;

		final String populateSpecialtiesTbl = 
				" INSERT  INTO specialties VALUES (1, 'radiology');"
				+ " INSERT  INTO specialties VALUES (2, 'surgery');"
				+ " INSERT  INTO specialties VALUES (3, 'dentistry');";
		
		final String populateVetSpecialtiesTbl =
		"INSERT  INTO vet_specialties VALUES (2, 1); "
		+ " INSERT  INTO vet_specialties VALUES (3, 2);"
		+ " INSERT  INTO vet_specialties VALUES (3, 3);"
		+ " INSERT  INTO vet_specialties VALUES (4, 2);"
		+ " INSERT  INTO vet_specialties VALUES (5, 1);";

		final String populateTypesTbl =
		"INSERT  INTO types VALUES (1, 'cat');"
		+ " INSERT  INTO types VALUES (2, 'dog');"
		+ " INSERT  INTO types VALUES (3, 'lizard');"
		+ " INSERT  INTO types VALUES (4, 'snake');"
		+ " INSERT  INTO types VALUES (5, 'bird');"
		+ " INSERT  INTO types VALUES (6, 'hamster');";

		final String populateOwnersTbl =
		" INSERT  INTO owners VALUES (1, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');"
		+ " INSERT  INTO owners VALUES (2, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');"
		+ " INSERT  INTO owners VALUES (3, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');"
		+ " INSERT  INTO owners VALUES (4, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');"
		+ " INSERT  INTO owners VALUES (5, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');"
		+ " INSERT  INTO owners VALUES (6, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');"
		+ " INSERT  INTO owners VALUES (7, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');"
		+ " INSERT  INTO owners VALUES (8, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');"
		+ " INSERT  INTO owners VALUES (9, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');"
		+ "INSERT  INTO owners VALUES (10, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');";

		final String populatePetsTbl =
		" INSERT  INTO pets VALUES (1, 'Leo', '2000-09-07', 1, 1);"
		+ " INSERT  INTO pets VALUES (2, 'Basil', '2002-08-06', 6, 2);"
		+ " INSERT  INTO pets VALUES (3, 'Rosy', '2001-04-17', 2, 3);"
		+ " INSERT  INTO pets VALUES (4, 'Jewel', '2000-03-07', 2, 3);"
		+ " INSERT  INTO pets VALUES (5, 'Iggy', '2000-11-30', 3, 4);"
		+ " INSERT  INTO pets VALUES (6, 'George', '2000-01-20', 4, 5);"
		+ " INSERT  INTO pets VALUES (7, 'Samantha', '1995-09-04', 1, 6);"
		+ " INSERT  INTO pets VALUES (8, 'Max', '1995-09-04', 1, 6);"
		+ " INSERT  INTO pets VALUES (9, 'Lucky', '1999-08-06', 5, 7);"
		+ " INSERT  INTO pets VALUES (10, 'Mulligan', '1997-02-24', 2, 8);"
		+ " INSERT  INTO pets VALUES (11, 'Freddy', '2000-03-09', 5, 9);"
		+ " INSERT  INTO pets VALUES (12, 'Lucky', '2000-06-24', 2, 10);"
		+ " INSERT  INTO pets VALUES (13, 'Sly', '2002-06-08', 1, 10);";

		final String populateVisitsTbl =
		"INSERT  INTO visits VALUES (1, 7, '2010-03-04', 'rabies shot');"
		+ "  INSERT INTO visits VALUES (2, 8, '2011-03-04', 'rabies shot');"
		+ " INSERT  INTO visits VALUES (3, 8, '2009-06-04', 'neutered');"
		+ " INSERT  INTO visits VALUES (4, 7, '2008-09-04', 'spayed');";
		
		try {
			conn.createStatement().executeUpdate(createVetsTbl);
			conn.createStatement().executeUpdate(createSpecialtiesTbl);
			conn.createStatement().executeUpdate(createVetSpecialtiesTbl);			
			conn.createStatement().executeUpdate(createTypesTbl);
			conn.createStatement().executeUpdate(createOwnersTbl);
			
			conn.createStatement().executeUpdate(createPetsTbl);
			conn.createStatement().executeUpdate(createVisitsTbl);
			
			conn.createStatement().executeUpdate(populateVetsTbl);
			conn.createStatement().executeUpdate(populateSpecialtiesTbl);
			conn.createStatement().executeUpdate(populateVetSpecialtiesTbl);
			conn.createStatement().executeUpdate(populateTypesTbl);
			conn.createStatement().executeUpdate(populateOwnersTbl);

			conn.createStatement().executeUpdate(populatePetsTbl);
			conn.createStatement().executeUpdate(populateVisitsTbl);
			
		} catch (SQLException sQLException) {
			sQLException.printStackTrace();

		} finally {
			// @formatter:off
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
			;
			// @format
		}
	}
}