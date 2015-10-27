package com.junit.rules;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class ExternalResourcesTest {
	Connection conn=null;
	
	@Rule
	public ExternalResource resource = new ExternalResource() {

		
		
		@Override
		protected void before() throws Throwable {
			String url = "jdbc:mysql://localhost:3306/mydatabase";
			String username="root";
			String password="root";
			conn = DriverManager.getConnection(url, username, password);
		}

		@Override
		protected void after() {
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	};
	
	
	@Test
	public void testEmployeeTableData() throws SQLException{
		
		String sql = "SELECT name FROM Employee";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		String name="";
		if(rs.next()){
		name = rs.getString(1);		
		}
		
		assertEquals("dinesh", name);
		
	}
	


}
