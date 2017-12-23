package com.example.data;

import java.sql.Connection;
import java.sql.SQLException;

public class ContactDB {

	public static void createPopulateH2() {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection conn = pool.getConnection();

		final String createProductTable = "DROP TABLE IF EXISTS contact;" 
		+ "CREATE TABLE contact(" 
		+ "`contact_id` int(11) NOT NULL AUTO_INCREMENT," 
		+ "`name` varchar(45) NOT NULL,"
		+ "`email` varchar(45) NOT NULL," 
		+ "`address` varchar(45) NOT NULL," 
		+ "`telephone` varchar(45) NOT NULL,"
		+ "PRIMARY KEY (contact_id));" ;
				

		final String populateProductTable = "INSERT INTO contact VALUES (1, 'name_1', 'email_1', 'addr_1', 'tel_1');";

		try {
			conn.createStatement().executeUpdate(createProductTable);
			conn.createStatement().executeUpdate(populateProductTable);

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