package com.service;

import java.util.ArrayList;

import com.bean.*;
import com.dao.*;

public class AccountService {

AccountDao dao = new AccountDao();
	
	public int insertAccount(Accountf a){
		
		int count = dao.addAccount(a);
		
		return count;
		
		
	}
	public Accountf retrieveAccount(int id){
		
		Accountf a = new Accountf();
		a = dao.viewAccount(id);
		
		return a;
		
		
	}
	public int deleteAcc(int accid)
	{
		int count = dao.deleteAccount(accid);
		return count;
	}
	public ArrayList<AccountStatusf> viewAllStatus(){
		AccountDao dao=new AccountDao();
		return dao.viewAllStatus();
	}

}
