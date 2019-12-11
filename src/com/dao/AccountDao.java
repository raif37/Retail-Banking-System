package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.bean.*;
import com.util.*;


public class AccountDao {
	
	
	
	public int addAccount(Accountf a){
		Connection con=null;
		int cnt = 0;
		try {
			System.out.println("customer id "+a.getCustomerid());
			System.out.println("ssn is "+a.getSsnid());
			con = DButil.getConnection();
			String query1="select ssnid from customerf where customer_id=?";
			PreparedStatement pst1=con.prepareStatement(query1);
			pst1.setInt(1,a.getCustomerid());
			ResultSet rs=pst1.executeQuery();
			int ssn=0;
			while(rs.next())
				ssn=rs.getInt("ssnid");
			if(ssn==0)
				return 0;
			String query = "insert into accountf values(?,?,acc_id.nextval,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, a.getCustomerid());
			pst.setInt(2,ssn);
			pst.setString(3, a.getAccounttype());
			pst.setDouble(4, a.getBalance());
			cnt=0;
			cnt = pst.executeUpdate();
			if(cnt==0)
				return 0;
			
			//UPDATING ACCOUNT STATUS TABLE
			

            PreparedStatement pst2=con.prepareStatement("insert into account_statusf" +
                    " values(?,acc_id.currval,?,'active','Account Creation initiated Successfully'," +
                    "sysdate)");
            pst2.setInt(1,a.getCustomerid());
            pst2.setString(2, a.getAccounttype());
            cnt=pst2.executeUpdate();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally{
			DButil.closeConnection(con);
		}

		return cnt;

	}
	
	public int deleteAccount(int id)

	   {
		   Connection con=null;
		   int cnt = 0;
		   try{
			   con = DButil.getConnection();

			String query = "delete from account_statusf where account_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			cnt = pst.executeUpdate();
			//if(cnt>0){
			query = "delete from transactionf where account_id=?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			cnt = pst.executeUpdate();
			//}
			//if(cnt>0){
				query = "delete from accountf where account_id=?";
				pst = con.prepareStatement(query);
				pst.setInt(1, id);
				cnt = pst.executeUpdate();
			//}
		   }
		   catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   finally{
				DButil.closeConnection(con);
			}
	         return cnt;
	   }
	   
   
   public ArrayList<AccountStatusf> viewAllStatus(){
	    ArrayList<AccountStatusf> list=new ArrayList<AccountStatusf>();
	    Connection con=null;
	    try {
	        con = DButil.getConnection();

	        PreparedStatement ps=con.prepareStatement("SELECT * FROM account_statusf");
	        ResultSet rs=ps.executeQuery();
	        while(rs.next()){
	            int custId=rs.getInt("customer_id");
	            int acctId=rs.getInt("account_id");
	            String acctType=rs.getString("account_type");
	            String status=rs.getString("status");
	            String message=rs.getString("message");
	            Timestamp last_update=rs.getTimestamp("last_updated");
	            //dateFormat.format(last_update);
	            AccountStatusf acctStatus=new AccountStatusf(custId,acctId,acctType, status, message, last_update);

	            //System.out.println(last_update);
	            list.add(acctStatus);
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
   
   public ArrayList<Integer> viewAccountId(int id ,String IdType)
   {
   	ArrayList<Integer> idlist=new ArrayList<Integer>();
   	String type=IdType;
   	Connection con=null;
   	//System.out.println("i am in a cust type details");
   	try {
   		if(type.equalsIgnoreCase("SSN ID"))
   		{
   			//System.out.println("i am in a ssn id");
   		  String query = "select account_id from accountf where ssnid=?";
   		  con = DButil.getConnection();
   		  PreparedStatement pst = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,
   		        ResultSet.CONCUR_READ_ONLY);	
   		  pst.setInt(1, id);
   		  ResultSet rs = pst.executeQuery();
   		  if(rs.next()==false)
         	return null;
   		  
   		  rs.first();
   		  idlist.add(rs.getInt(1));
   		 while(rs.next())
   		 {
   		   int ids= rs.getInt(1);
   		   idlist.add(ids);
   		   //System.out.println(ids);
   		  }
   		}
   		else if(type.equalsIgnoreCase("Customer ID"))
   		{
   			System.out.println("i am in a customer id");
   			String query = "select account_id from accountf where customer_id=?";
   			 con = DButil.getConnection();
   			  PreparedStatement pst = con.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,
   	   		        ResultSet.CONCUR_READ_ONLY);	
   			  pst.setInt(1, id);
   	     	  ResultSet rs = pst.executeQuery();
   	     	 if(rs.next()==false)
   	         	return null;
   	   		  
   	   		  
   	     	 	rs.first();
   	     	 	idlist.add(rs.getInt(1));
   	   		 while(rs.next())
   	   		 {
   		 
   			   int ids= rs.getInt(1);
   		     	idlist.add(ids);
   		        System.out.println(ids);

   				
   			  }
   		}
   		}
   		 catch (SQLException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		} catch (Exception e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
   		finally{
   			DButil.closeConnection(con);
   		}
   	return idlist;

   	
   	
   }


   public Accountf viewAccount(int id)
   {	

   	Accountf acc= new Accountf();
   	Connection con=null;
   	try {
   		String query = "select customer_id ,account_id,account_type, balance from accountf where account_id=?";
   		con = DButil.getConnection();
   		PreparedStatement pst = con.prepareStatement(query);	
   		pst.setInt(1, id);
       
   		ResultSet rs = pst.executeQuery();
   		
   		while(rs.next()){
   			
   		int cid= rs.getInt("customer_id");
   		int aid=	rs.getInt("account_id");
   		String atype=rs.getString("account_type");
   	    double bal=rs.getDouble("balance");
   	    
   			acc=new Accountf(aid,cid,atype,bal);
   		}
   		}

   		 catch (SQLException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		} catch (Exception e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
   		finally{
			DButil.closeConnection(con);
		}

   	return acc;
   	
   }
		
   public ArrayList<Accountf> viewAccountIdTable(int id ,String IdType)
   {
   	ArrayList<Accountf> idlist=new ArrayList<Accountf>();
   	String type=IdType;
   	Connection con=null;
   	//System.out.println("i am in a cust type details");
   	try {
   		if(type.equalsIgnoreCase("SSN ID"))
   		{
   			//System.out.println("i am in a ssn id");
   		  String query = "select * from accountf where ssnid=?";
   		  con = DButil.getConnection();
   		  PreparedStatement pst = con.prepareStatement(query);	
   		  pst.setInt(1, id);
        	  ResultSet rs = pst.executeQuery();
   		 while(rs.next())
   		 {
   	 
   		   int acctid= rs.getInt("account_id");
   		   String accttype=rs.getString("account_type");
   		   double balance=rs.getDouble("balance");
   		   
   		   Accountf acct=new Accountf();
   		   
   		   acct.setAccountid(acctid);
   		   acct.setAccounttype(accttype);
   		   acct.setBalance(balance);
   		   idlist.add(acct);
   		   //System.out.println(ids);
   		  }
   		}
   		else if(type.equalsIgnoreCase("Customer ID"))
   		{
   			//System.out.println("i am in a customer id");
   			String query = "select * from accountf where customer_id=?";
   			  con = DButil.getConnection();
   			  PreparedStatement pst = con.prepareStatement(query);	
   			  pst.setInt(1, id);
   	     	  ResultSet rs = pst.executeQuery();
   			 while(rs.next())
   			 {
   		 
   				 int acctid= rs.getInt("account_id");
   	  		   	String accttype=rs.getString("account_type");
   	  		   	double balance=rs.getDouble("balance");
   	  		   
   	  		   	Accountf acct=new Accountf();
   	  		   
   	  		   	acct.setAccountid(acctid);
   	  		   	acct.setAccounttype(accttype);
   	  		   	acct.setBalance(balance);
   	  		   	idlist.add(acct);

   			  }
   		}
   		}
   		 catch (SQLException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		} catch (Exception e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
   		finally{
   			DButil.closeConnection(con);
   		}
   	return idlist;

   	
   	
   }
	
}
