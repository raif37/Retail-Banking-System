package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.sql.Date;

import com.bean.*;

import com.util.*;

//import org.apache.log4j.Logger;

public class TransactionDao{
	
	//static final Logger LOGGER = Logger.getLogger(TransactionDao.class);
	public ArrayList deposit(Accountf account,double amount){
		Connection con=null;
		ArrayList ret=new ArrayList();
		int result=0;
		try{
			System.out.println(account.getAccountid());
			con=DButil.getConnection();
			PreparedStatement pst1=con.prepareStatement("SELECT balance from accountf where account_id=?");
			pst1.setInt(1,account.getAccountid());
			ResultSet rs=pst1.executeQuery();
			double balance=-1;
			while(rs.next()){
				System.out.println(rs.getDouble("balance"));
				balance=rs.getDouble(1);
			}
			
			System.out.println("balance is "+balance);
			if(balance==-1){
				ret.add(0);
				return ret;
			}
			
			double newBalance=balance+amount;
			account.setBalance(balance);
			PreparedStatement pst2=con.prepareStatement("UPDATE accountf SET balance="+
					"? WHERE account_id=?");
			pst2.setDouble(1,newBalance);
			pst2.setInt(2,account.getAccountid());
			result=pst2.executeUpdate();
			if(result!=1){
				ret.add(result);
				return ret;
			}
			else{
				PreparedStatement pst3=con.prepareStatement("INSERT INTO transactionf VALUES(trans_id.nextval" +
						",?,?,'credit','Deposited "+amount+"',sysdate)");
				pst3.setInt(1,account.getAccountid());
				pst3.setDouble(2,newBalance);
				result=pst3.executeUpdate();
				ret.add(result);
				ret.add(account.getAccountid());
				ret.add(balance);
				ret.add(newBalance);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			ret.add(0);
			return ret;
		}
		finally{
			DButil.closeConnection(con);
		}
		return ret;
}
	
	public ArrayList withdraw(Accountf account,double amount){
    Connection con=null;
    int result=0;
    ArrayList ret=new ArrayList();
    try{
        con=DButil.getConnection();
        
        PreparedStatement pst1=con.prepareStatement("SELECT balance from accountf where " +
				"account_id=?");
        pst1.setInt(1, account.getAccountid());
		ResultSet rs=pst1.executeQuery();
		double balance=-1;
		while(rs.next()){
			balance=rs.getDouble(1);
		}
		
		if(balance==-1){
			ret.add(0);
			return ret;
		}
        
		if(balance<amount){
			ret.add(-1);
			return  ret;
		}
        
		double newBalance=balance-amount;
        PreparedStatement pst2=con.prepareStatement("UPDATE accountf SET balance=? WHERE account_id=?");
        pst2.setDouble(1,newBalance);
		pst2.setInt(2,account.getAccountid());
        result=pst2.executeUpdate();
        
        if(result!=1){
        	ret.add(result);
			return ret;
        }
		else{
			PreparedStatement pst3=con.prepareStatement("INSERT INTO transactionf VALUES(trans_id.nextval" +
					",?,?,'debit','Withdrawal of "+amount+"',sysdate)");
			pst3.setInt(1,account.getAccountid());
			pst3.setDouble(2,newBalance);
			result=pst3.executeUpdate();
			ret.add(result);
			ret.add(account.getAccountid());
			ret.add(balance);
			ret.add(newBalance);
		}
    }
    catch(Exception e){
        e.printStackTrace();
        ret.add(0);
        return ret;
    }
    finally{
    	DButil.closeConnection(con);
    }
    return ret;
	}

	public ArrayList transfer(int amount,int source,int target){
		Connection con=null;
	    int result=0;
	    ArrayList ret=new ArrayList();
	    try{
	        con=DButil.getConnection();
	        
	        //check whether source account exists
	        PreparedStatement ps1=con.prepareStatement("SELECT account_id,balance FROM " +
	        		"accountf WHERE account_id=?");
	        ps1.setInt(1, source);
	        boolean sourceExists=false;
	        double sourceBalance=-1;
	        ResultSet rs1=ps1.executeQuery();
	        while(rs1.next()){
	        	sourceExists=true;
	        	sourceBalance=rs1.getDouble("balance");
	        }
	        if(!sourceExists){
	        	ret.add("Source account not found");
	        	return ret;
	        }
	        
	        //check whether target account exist
	        PreparedStatement ps2=con.prepareStatement("SELECT account_id,balance FROM " +
	        		"accountf WHERE account_id=?");
	        ps2.setInt(1, target);
	        boolean targetExists=ps2.execute();
	        double targetBalance=-1;
	        ResultSet rs2=ps2.executeQuery();
	        while(rs2.next()){
	        	targetExists=true;
	        	targetBalance=rs2.getDouble("balance");
	        }
	        if(!targetExists){
	        	ret.add("Target account not found");
	        	return ret;
	        }
	        
	        // if available balance is less than amount specified
	        if(sourceBalance<amount){
	        	ret.add("Transfer not allowed, please choose smaller amount");
	        	return ret;
	        }
	        
	        //source account balance updated
	        double newSourceBalance=sourceBalance-amount;
	        PreparedStatement ps3=con.prepareStatement("UPDATE accountf SET balance="+
					"? WHERE account_id=?");
	        ps3.setDouble(1, newSourceBalance);
	        ps3.setInt(2, source);
	        
	        int sourceUpdate=ps3.executeUpdate();
	        if(sourceUpdate==0){
	        	ret.add("Internal error");
	        	return ret;
	        }
	        //target account balance updated
	        double newTargetBalance=targetBalance+amount;
	        
	        PreparedStatement ps4=con.prepareStatement("UPDATE accountf SET balance="+
					"? WHERE account_id=?");
	        ps4.setDouble(1, newTargetBalance);
	        ps4.setInt(2, target);
	        
	        int targetUpdate=ps4.executeUpdate();
	        if(targetUpdate==0){
	        	ret.add("Internal error");
	        	return ret;
	        }
	        //insert transaction for source account
	        PreparedStatement ps5=con.prepareStatement("INSERT INTO transactionf VALUES(trans_id.nextval" +
					",?,?,'debit','Transfer of "+amount+" to "+target+"',sysdate)");
	        ps5.setInt(1,source);
			ps5.setDouble(2,newSourceBalance);
			int sourceTransactionstatus=ps5.executeUpdate();
			
			PreparedStatement ps6=con.prepareStatement("INSERT INTO transactionf VALUES(trans_id.nextval" +
					",?,?,'credit','Transfer of "+amount+" from "+source+"',sysdate)");
	        ps6.setInt(1,target);
			ps6.setDouble(2,newTargetBalance);
			
			int targetTransactionstatus=ps6.executeUpdate();
	        
	        ret.add("Amount transfer completed successfully");
	        ret.add(source);
	        ret.add(sourceBalance);
	        ret.add(newSourceBalance);
	        
	        ret.add(target);
	        ret.add(targetBalance);
	        ret.add(newTargetBalance);
	    }
	    catch(Exception e){
	        	ret.add("Internal error");
	        	return ret;
	    }
	    finally{
	    	DButil.closeConnection(con);
	    }
	    
	    return ret;
	}
	
	public ArrayList<Transactionf> viewStatement(int accountId,int days){
		ArrayList<Transactionf> result=new ArrayList<Transactionf>();
		Connection con=null;
		try{
			con=DButil.getConnection();
			PreparedStatement pst=con.prepareStatement("SELECT * FROM (SELECT * FROM transactionf"+
					" WHERE account_id=? ORDER BY trans_date DESC) WHERE rownum<=?"
					);
			pst.setInt(1,accountId);
			pst.setInt(2,days);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				String id=rs.getString("transaction_id");
				int acctId=rs.getInt("account_id");
				Timestamp date=rs.getTimestamp("trans_date");
				String description=rs.getString("message");
				String type=rs.getString("transaction_type");
				double balance=rs.getDouble("amount");
				Transactionf t=new Transactionf(id, acctId, date, description, type, balance);
				result.add(t);
			}
			//LOGGER.info("Successfully viewed statement of "+accountId);
		}
		catch(Exception e){
			//LOGGER.info(e.getStackTrace());
			e.getStackTrace();
		}
		
		return result;
	}

	public ArrayList<Transactionf> viewStatement(int accountId,Timestamp start,Timestamp end){
		ArrayList<Transactionf> result=new ArrayList<Transactionf>();
		Connection con=null;
		try{
			con=DButil.getConnection();
			PreparedStatement pst=con.prepareStatement("SELECT * FROM transactionf"+
					" WHERE account_id=? AND trans_date BETWEEN ? AND ?");
			pst.setInt(1,accountId);
			pst.setTimestamp(2, start);
			pst.setTimestamp(3,end);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()){
				String id=rs.getString("transaction_id");
				int acctId=rs.getInt("account_id");
				Timestamp date=rs.getTimestamp("trans_date");
				String description=rs.getString("message");
				String type=rs.getString("transaction_type");
				double balance=rs.getDouble("amount");
				Transactionf t=new Transactionf(id, acctId, date, description, type, balance);
				result.add(t);
			}
			//LOGGER.info("Successfully viewed statement of "+accountId);
		}
		catch(Exception e){
			//LOGGER.info(e.getStackTrace());
			e.printStackTrace();
		}
		
		return result;
	}
}


