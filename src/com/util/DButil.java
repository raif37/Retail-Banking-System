package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	
	private static final String DRIVERNAME="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@172.25.192.70:1521:xe";
	private static final String USERNAME="HJA17ORAUSER2D";
	private static final String PASSWORD="tcshyd";
	public static Connection getConnection(){
			
		Connection con=null;
		/*String url = "jdbc:oracle:thin:@//localhost:1521/XE";
		String driver = "oracle.jdbc.driver.OracleDriver";	

		
		String user = "system";		
		String pwd = "root";*/

		
			try {
				Class.forName(DRIVERNAME);
				con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
	//			Class.forName(driver);
		//		con=DriverManager.getConnection(url,user,pwd);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			return con;
			
		}
				
		public static void closeConnection(Connection  con){
			
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			}
		}

}
