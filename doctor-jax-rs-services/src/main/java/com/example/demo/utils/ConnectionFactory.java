package com.example.demo.utils;

import java.sql.Connection;
import com.example.demo.enums.*;
public class ConnectionFactory {

	public static Connection getConnection(Database key) {
		
		switch (key) {
		case ORACLE:
			return DbConnection.getOracleConnection();
	

	    case POSTGRES:
	    	return DbConnection.getPostgresConnection();
			
		default:
			return null;
		}
		    
		
		}

	}

