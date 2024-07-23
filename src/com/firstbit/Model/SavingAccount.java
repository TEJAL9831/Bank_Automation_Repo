package com.firstbit.Model;

import java.time.LocalDate;
import java.util.Scanner;

import com.firstbit.Exception.AccountException;

public  class SavingAccount extends Account {

	private Scanner sc=new Scanner(System.in);
	public SavingAccount() {
		super();
	    this.setInterestRate(0.04);
	}

	@Override
	public void openAccount() {
		   System.out.println("==========================================================");
		   System.out.println("To Open Saving Account,Please fill the below Information :");
		   System.out.println("==========================================================");
		   /*System.out.println("Enter Account Number ");
		   Integer accNum=sc.nextInt();*/
		   System.out.println("Enter Account Holder Name ");
		   String accHolderName=sc.nextLine();
		   System.out.println("Enter Balance , You Want to Start With ");
		   Double accBalance=sc.nextDouble();
		  

			try {
				 
				   this.setAccountNumber(generateAccountNumber());
				   this.setAccountHolderName(accHolderName);
				if (accBalance < 10000) {
					throw new AccountException("Account must be opened with a minimum initial balance of 10,000 Rs");
				}
				this.setBalance(accBalance); // Move this line outside the try block
				  this.setOpenAccountDate(LocalDate.now());
				  // System.out.println("Your Account Open Successfully");
				  System.out.println("Mr/Mrs,Miss "+ accHolderName+ " Your Saving Account Open Successfully ,Your  Account Number is : " + getAccountNumber());

			} catch (AccountException e) {
				// Handle the exception appropriately, e.g., log or display an error message
				System.out.println("Error: " + e.getMessage());
			}

		 
		
		  
	}

	 
	@Override
	public void depositInAccount() {
		
		System.out.println("Enter the deposite Amount ::");
		Double amount=sc.nextDouble();
		
		// here we write business logic set new balance from adding new amount and print total balance
		this.setBalance(this.getBalance()+amount);
		System.out.println("Total Balance :: "+this.getBalance());
		
	}

	@Override
	public void withdrawFromAccount() {
		
		 System.out.println("Enter the withdraw amount :: ");
		 Double withdrawAmount=sc.nextDouble();
		 
		 Double tempamount=this.getBalance()-withdrawAmount;
		 
		 if(this.getBalance()>withdrawAmount)
		 {
		    if(tempamount > 10000)
		    {
				this.setBalance(this.getBalance()-withdrawAmount);
				System.out.println("Your Transaction is of  "+withdrawAmount+" Successfully complete...!");
		    }
		    else
		    	System.out.println("Minimum Amount Limit Breach,10000");
	
		 }
		 else
			 System.out.println("Insufficient Balance.....!");

		
	}

	@Override
	public void calculateInterest() {
		
		//suppose we have balance is 15000 and interest rate is 0.04
		
		 Double interestAmount=this.getBalance()*this.getInterestRate();
		 System.out.println("Interest  On Saving Account :: "+interestAmount);
		/* this.setBalance(this.getBalance()+interest);
		 System.out.println("After calculating interest balance is "+this.getBalance());*/
		
	}

	@Override
	public void showAccountTransaction() {
	
		System.out.println("Hello Mr./Mrs./Miss :: "+this.getAccountHolderName());
	    System.out.println("Having Account Number :: "+this.getAccountNumber());
	    System.out.println("With Balance of :: "+this.getBalance());
	    System.out.println("Applying Interest Rate on Balance Would Be :: "+this.getInterestRate());
	   
	    System.out.println("Note Your Account Opening Date Was :: "+this.getOpenAccountDate());
	    
		
	}

	
	      
	    

}
