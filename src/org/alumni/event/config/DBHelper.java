package org.alumni.event.config;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHelper 
{
	protected DBConfig db = DBConfig.getInstance();
	protected Connection conn = db.getconnection();
	protected PreparedStatement pstmt = db.getStatement();
	protected ResultSet rs = db.getResult();
}
