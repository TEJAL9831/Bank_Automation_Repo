package com.firstbit.Model;

import java.time.LocalDate;
import java.util.Random;

import com.firstbit.Exception.AccountException;

public  abstract class Account {

	       private Integer accountNumber;
	       private String accountHolderName;
	       private Double balance;
	       private Double interestRate;
	       private LocalDate openAccountDate;
	       
	      //no-arguement constructor
	      public Account()
	       {
	    	    this.accountNumber=0;
	    	    this.accountHolderName=null;
	    	    this.balance=0.0;
	    	    this.interestRate=0.05;
	    	    this.openAccountDate=null;
	    	   
	       }
	      
	      
	      //parameterized constructor

		public Account(Integer accountNumber, String accountHolderName, Double balance, Double interestRate,
				LocalDate openAccountDate) {
			super();
			 this.accountNumber = generateAccountNumber();
			this.accountHolderName = accountHolderName;
			this.balance = balance;
			this.interestRate = interestRate;
			this.openAccountDate = openAccountDate;
		}

		// Getter setter method to set and retrived value of private fields

		public Integer getAccountNumber() {
			return accountNumber;
		}


		public void setAccountNumber(Integer accountNumber) {
			this.accountNumber = accountNumber;
		}


		public String getAccountHolderName() {
			return accountHolderName;
		}


		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}


		public Double getBalance() {
			return balance;
		}


		public void setBalance(Double balance) {
			this.balance = balance;
		}


		public Double getInterestRate() {
			return interestRate;
		}


		public void setInterestRate(Double interestRate) {
			this.interestRate = interestRate;
		}


		public LocalDate getOpenAccountDate() {
			return openAccountDate;
		}


		public void setOpenAccountDate(LocalDate openAccountDate) {
			this.openAccountDate = openAccountDate;
		}


		@Override
		public String toString() {
			return "Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName + ", balance="
					+ balance + ", interestRate=" + interestRate + ", openAccountDate=" + openAccountDate + "]";
		}
	      
		// abstract method
		    public abstract void openAccount() throws AccountException;

		    public abstract void depositInAccount() throws AccountException;

		    public abstract void withdrawFromAccount() throws AccountException;

		    public abstract void calculateInterest() throws AccountException;

		    public abstract void showAccountTransaction() throws AccountException;

		
		// to genrate account number after account is open 
		public int generateAccountNumber() {
		    Random random = new Random();
		    // Generate a random integer between 1000 and 9999 (or any range you prefer)
		    return random.nextInt(9000) + 1000;
		}
	       
}
