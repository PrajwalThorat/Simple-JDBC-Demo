package com.stackroute.simple_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	Connection con=null;
    	ResultSet rs=null;
    	try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/DataDB", "root", "root");
			
			//executing statement
			Statement stm=con.createStatement();
			rs=stm.executeQuery("select * from USER");
			
			while(rs.next()) {
				System.out.println("User ID: "+rs.getInt(1)+", User Name: "+rs.getString(2)
				+", User Email: "+rs.getString(3)+", User City: "+rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			rs.close();
			con.close();
		}
    	
    }
}
