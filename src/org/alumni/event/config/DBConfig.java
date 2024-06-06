package org.alumni.event.config;
import java.io.*;
import java.sql.*;
import java.util.*;
public class DBConfig {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static DBConfig db;
	
	private DBConfig()
	{
		try
		{
			Properties p = new Properties();
			p.load(PathHelper.fin);
			String driverClassName = p.getProperty("driver.classname");
			String username = p.getProperty("db.username");
			String password = p.getProperty("db.password");
			String url = p.getProperty("db.url");
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);
			if(conn!=null)
			{
				System.out.println("Database is connected:");
			}
			else
			{
				System.out.println("Database is Not Connected:");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
	}
	public static DBConfig getInstance()
	{
		if(db==null)
		{
			db=new DBConfig();
		}
		return db;
	}
	public Connection getconnection()
	{
		return conn;
	}
	public PreparedStatement getStatement()
	{
		return pstmt;
	}
	public ResultSet getResult()
	{
		return rs;
	}
}
