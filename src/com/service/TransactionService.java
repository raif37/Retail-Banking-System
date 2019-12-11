package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import com.bean.*;
import com.dao.*;

public class TransactionService {
	TransactionDao dao=new TransactionDao();
	public ArrayList deposit(Accountf account,double amount){
		
		return dao.deposit(account, amount);
	}
	public ArrayList withdraw(Accountf account,double amount){

		return dao.withdraw(account, amount);
	}
	public ArrayList transfer(int amount,int source,int target){
		
		return dao.transfer(amount,source,target);
	}
	public ArrayList<Transactionf> getStatement(int accountId,int days){
		return dao.viewStatement(accountId, days);
	}
	
	public ArrayList<Transactionf> getStatement(int accountId,Timestamp start,Timestamp end){
		return dao.viewStatement(accountId, start,end);
	}
}
