package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.Employeef;
import com.util.DButil;

public class Logindao {

	public int checkEmployee(Employeef emp)
	{
		int r=0;
		Connection con=null;
		try{
			con=DButil.getConnection();
			PreparedStatement ps=con.prepareStatement("SELECT role from employeef "+
			"WHERE emp_id=? AND password=?");
			
			ps.setString(1, emp.getEmployee_id());
			ps.setString(2, emp.getPassword());
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String type=rs.getString(1);
				if(type.equals("cae"))
					r=1;
				else if(type.equals("cashier")|| type.equals("teller"))
					r=2;
			}
		}
		catch(Exception e){
			r=-1;
			DButil.closeConnection(con);
			e.printStackTrace();
		}
		finally{
			DButil.closeConnection(con);
		}
		System.out.println(r);
		return r;

	}

}
