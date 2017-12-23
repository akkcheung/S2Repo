package com.example.util;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;

public class DataSourceFactory {

	public static DataSource getH2DataSource() {
		return JdbcConnectionPool.create(
					"jdbc:h2:mem:mydb;DB_CLOSE_DELAY=-1", "user", "password");
		
	}
}
