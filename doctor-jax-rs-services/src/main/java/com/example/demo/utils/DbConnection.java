package com.example.demo.utils;
import java.awt.im.InputContext;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
public class DbConnection {

	public static Connection getOracleConnection()
	{
		Connection con= null;
		
		try {
			
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con =DriverManager.getConnection("jdbc:oracle:thin:@10.90.1.107:1521:SIT","TRAINING","TRAINING");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@10.90.1.105:1521/DEV","HR","HR");
			
			InputStream inStream = DbConnection.class.getClassLoader().getResourceAsStream("DbConnection.properties");
			
			
			Properties props = new Properties();
			props.load(inStream);
			
			con=DriverManager.getConnection(props.getProperty("datasource.oracle.url"),props.getProperty("datasource.oracle.userName"),props.getProperty("datasource.oracle.password"));
		} catch (SQLException |IOException e) {
		      e.printStackTrace();
		}
		return con;
	}
	
	public static Connection getPostgresConnection()
	{
		Connection con= null;
		
		try {
			
		//	Class.forName("org.postgresql.Driver");
			
			InputStream inStream = DbConnection.class.getClassLoader().getResourceAsStream("DbConnection.properties");
			
			
			Properties props = new Properties();
			props.load(inStream);
			
			con=DriverManager.getConnection(props.getProperty("datasource.postgres.url"),props.getProperty("datasource.postgres.userName"),props.getProperty("datasource.postgres.password"));
		} catch (SQLException |IOException e) {
		      e.printStackTrace();
		}
		return con;
	}
}
