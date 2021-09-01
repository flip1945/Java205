package com.bitcamp.sc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScApplicationTests {
	
	private DataSource dataSource;
	private Connection conn;
	
	@Autowired
	ScApplicationTests(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testConnection() throws SQLException {
		System.out.println(dataSource);
		conn = dataSource.getConnection();
		
		System.out.println(conn);
		conn.close();
	}

}
