package com.firstbit.Model;

import java.time.LocalDate;
import java.util.Scanner;

public class LoanAccount extends SavingAccount{
	
	  private Scanner sc=new Scanner(System.in);
	  Double repay;
	  
	  public LoanAccount()
	  {
		  super();
		  this.repay=0.0;
		  this.setInterestRate(0.94);
		
	  }

	public Double getRepay() {
		return repay;
	}

	public void setRepay(Double repay) {
		this.repay = repay;
	}
	
	
	public void openAccount() {
		   System.out.println("==========================================================");
		   System.out.println("To Open Loan Account,Please fill the below Information :");
		   System.out.println("==========================================================");
		 /*  System.out.println("Enter Account Number ");
		   Integer accNum=sc.nextInt();*/
		   System.out.println("Enter Account Holder Name ");
		   String accHolderName=sc.nextLine();
		   System.out.println("Enter Balance , You Want to Start With ");
		   Double accBalance=sc.nextDouble();
		   
		  
		   this.setAccountNumber(generateAccountNumber());
		   this.setAccountHolderName(accHolderName);
		   this.setBalance(accBalance);
		   this.setOpenAccountDate(LocalDate.now());
		   System.out.println("Mr/Mrs,Miss "+ accHolderName+ " Your Laon Account Open Successfully ,Your  Account Number is : " + getAccountNumber());

	}
@Override	
public void depositInAccount() {
		
		System.out.println("Enter the Deposite Repay Amount ::");
		Double repayamount=sc.nextDouble();
		
		// here we write business logic set new balance from adding new amount and print total balance
		this.setRepay(repayamount);
		
		this.setBalance(this.getBalance()-this.getRepay());
		System.out.println("Total Balance :: "+this.getBalance());
		
	}
@Override
public void withdrawFromAccount()
{
	   System.out.println("You Can't Withdraw amount from Loan Account ");
	}

@Override
public void calculateInterest() {
	
	Double interestAmount=this.getBalance()+this.getInterestRate();
	System.out.println("Inetrest on Loan  Account :: "+interestAmount);
	
}

public void showRepayAmount() {
    System.out.println("Repay Amount for Loan Account :: " + this.getRepay());
}

@Override
public void showAccountTransaction() {
	// TODO Auto-generated method stub
	System.out.println("Hello Mr./Mrs./Miss :: "+this.getAccountHolderName());
    System.out.println("Having Account Number :: "+this.getAccountNumber());
    System.out.println("With Balance of :: "+this.getBalance());
    System.out.println("Note Your Account Opening Date Was :: "+this.getOpenAccountDate());
    
	
}

}
