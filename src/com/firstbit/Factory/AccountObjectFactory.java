package com.firstbit.Factory;

import com.firstbit.Model.Account;
import com.firstbit.Model.CurrentAccount;
import com.firstbit.Model.LoanAccount;
import com.firstbit.Model.SalaryAccount;
import com.firstbit.Model.SavingAccount;

public class AccountObjectFactory {
	
	   public static Account getAccountObject(String accountType) {
	        Account account = null;
	        switch (accountType.toLowerCase()) {
	            case "saving":
	                account = new SavingAccount();
	                break;
	            case "current":
	                account = new CurrentAccount();
	                break;
	            case "loan":
	                account = new LoanAccount(); 
	                break;
	            case "salary":
	                account = new SalaryAccount();
	               
	                break;
	            default:
	              System.out.println("Invalid Account type");
	        }

	        return account;//return account saving ,current so on....
	    }
	}


