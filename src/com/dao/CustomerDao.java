package com.dao;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import com.bean.*;
import com.util.*;
//import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class CustomerDao {

public int addNewCustomer(Customerf c)
{
    int count = 0;
    Connection con=null;
    try {
            con = DButil.getConnection();

            String query = "insert into customerf values(cust_id.nextval,?," +
                    "?,?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, c.getSsnid());
            pst.setString(2, c.getName());
            pst.setInt(3,c.getAge());
            pst.setString(4, c.getAddress1());
            pst.setString(5, c.getAddress2());
            pst.setString(6, c.getCity());
            pst.setString(7, c.getState());

            count = pst.executeUpdate();

            PreparedStatement pst2=con.prepareStatement("select customer_id from " +
                    "customerf where ssnid=?");
            pst2.setInt(1,c.getSsnid());
            ResultSet rs=pst2.executeQuery();
            int id=0;
            while(rs.next()){
                id=rs.getInt(1);
            }
            if(id==0)
                return 0;

            PreparedStatement pst3=con.prepareStatement("insert into customer_statusf" +
                    " values(?,?,'active','Customer creation initiated successfully'," +
                    "sysdate)");
            pst3.setInt(1,id);
            pst3.setInt(2,c.getSsnid());

            count=pst3.executeUpdate();

    }
    catch (SQLException e1) {

        e1.printStackTrace();
        return 0;
    }
    catch (Exception e1) {

        e1.printStackTrace();
        return 0;
    }
    finally{
			DButil.closeConnection(con);
		}
    return count;
}
public CustomerStatusf searchCustomer(int id){

    CustomerStatusf cust = new CustomerStatusf();
    Connection con=null;
    try {
            con = DButil.getConnection();
            String query = "select * from CUSTOMER_STATUSf a left outer join customerf"+
                        " b on a.customer_id=b.customer_id where a.customer_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            	
                cust.setAddress1(rs.getString("address_line1"));
                cust.setAddress2(rs.getString("address_line2"));
                cust.setAge(rs.getInt("age"));
                cust.setCity(rs.getString("city"));
                cust.setCustomerid(rs.getInt("customer_id"));
                cust.setName(rs.getString("name"));
                cust.setSsnid(rs.getInt("ssnid"));
                cust.setState(rs.getString("state"));
                cust.setStatus(rs.getString("status"));
                cust.setMessage(rs.getString("message"));
                cust.setLastUpdated(rs.getTimestamp("last_updated"));
                return cust;
            }           
    }
    catch (SQLException e1) {

            e1.printStackTrace();
    }
    catch (Exception e1) {

            e1.printStackTrace();
    }
    finally{
		DButil.closeConnection(con);
	}
    return null;

}

public CustomerStatusf searchCustomerSSN(int id){

    CustomerStatusf cust = new CustomerStatusf();
    Connection con=null;
    try {
            con = DButil.getConnection();

            String query = "select * from CUSTOMER_STATUSf a left outer join customerf"+
                    " b on a.customer_id=b.customer_id where a.ssnid=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                cust.setAddress1(rs.getString("address_line1"));
                cust.setAddress2(rs.getString("address_line2"));
                cust.setAge(rs.getInt("age"));
                cust.setCity(rs.getString("city"));
                cust.setCustomerid(rs.getInt("customer_id"));
                cust.setName(rs.getString("name"));
                cust.setSsnid(rs.getInt("ssnid"));
                cust.setState(rs.getString("state"));
                cust.setStatus(rs.getString("status"));
                cust.setMessage(rs.getString("message"));
                cust.setLastUpdated(rs.getTimestamp("last_updated"));

            return cust;
            }           
    }
    catch (SQLException e1) {

            e1.printStackTrace();
    }
    catch (Exception e1) {

            e1.printStackTrace();
    }
    finally{
		DButil.closeConnection(con);
	}
    return null;

}
public int UpdateCustomer(CustomerStatusf c) throws Exception
{
    int count = 0;
    Connection con=null;
    try {
            con = DButil.getConnection();

            String query = "update customerf set name=?,age=?,address_line1=?,"+
                        "address_line2=?,city=?,state=? where customer_id=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, c.getName());
            pst.setInt(2, c.getAge());
            pst.setString(3,c.getAddress1());
            pst.setString(4, c.getAddress2());
            pst.setString(5, c.getCity());
            pst.setString(6, c.getState());
            pst.setInt(7, c.getCustomerid());       
            count = pst.executeUpdate();

            // UPDATING CUSTOMER STATUS TABLE
            PreparedStatement pst2=con.prepareStatement("update customer_statusf" +
                    " set status=?,message=?," +
                    "last_updated=sysdate where customer_id=?");
            pst2.setString(1, c.getStatus());
            pst2.setString(2, c.getMessage());
            pst2.setInt(3, c.getCustomerid());
            count=pst2.executeUpdate();
    }
    catch (SQLException e1) {

            e1.printStackTrace();
    }
    catch (Exception e1) {

            e1.printStackTrace();
    }
    finally{
		DButil.closeConnection(con);
	}
    return count;
}

public ArrayList<CustomerStatusf> viewAllStatus(){
    ArrayList<CustomerStatusf> list=new ArrayList<CustomerStatusf>();
    Connection con=null;
    try {
        con = DButil.getConnection();

        PreparedStatement ps=con.prepareStatement("SELECT * FROM customer_statusf");
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int id=rs.getInt("customer_id");
            int ssn=rs.getInt("ssnid");
            String status=rs.getString("status");
            String message=rs.getString("message");
            Timestamp last_update=rs.getTimestamp("last_updated");
            //dateFormat.format(last_update);
            CustomerStatusf custStatus=new CustomerStatusf(ssn, id, status, message, last_update);

            //System.out.println(last_update);
            list.add(custStatus);
        }
    }
    catch (SQLException e1) {

        e1.printStackTrace();
    }
    catch (Exception e1) {

        e1.printStackTrace();
    }
    finally{
        DButil.closeConnection(con);
    }

    return list;
}

public int deleteCustomer(int customerID) {

	int check = 0;
	Connection con=null;
	try{
		con = DButil.getConnection();
		String query = "DELETE FROM account_statusf WHERE customer_id=?";
		PreparedStatement statement =con.prepareStatement(query);
		statement.setInt(1,customerID);
		check=statement.executeUpdate();
		
			query = "select account_id FROM accountf WHERE customer_id=?";
			statement =con.prepareStatement(query);
			statement.setInt(1,customerID);
			ResultSet rs=statement.executeQuery();
			ArrayList<Integer> alist = new ArrayList<>();
			while(rs.next()){
				alist.add(rs.getInt(1));
			}
			for(Integer i : alist){
				query = "delete FROM transactionf WHERE account_id=?";
				statement =con.prepareStatement(query);
				statement.setInt(1,i);
				check=statement.executeUpdate();
			}
		
		
			query = "DELETE FROM customer_statusf WHERE customer_id=?";
			statement =con.prepareStatement(query);
			statement.setInt(1,customerID);
			check=statement.executeUpdate();
		
		
			query = "DELETE FROM accountf WHERE customer_id=?";
			statement =con.prepareStatement(query);
			statement.setInt(1,customerID);
			check=statement.executeUpdate();
	
		
			query = "DELETE FROM customerf WHERE customer_id=?";
			statement =con.prepareStatement(query);
			statement.setInt(1,customerID);
			check=statement.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally{
			DButil.closeConnection(con);
		}
	
	
	// TODO Auto-generated method stub
	return check;
}
}

