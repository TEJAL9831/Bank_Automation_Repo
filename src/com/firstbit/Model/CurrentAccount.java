package com.firstbit.Model;

import java.time.LocalDate;
import java.util.Scanner;
public  class CurrentAccount extends Account{
	
	private Scanner sc=new Scanner(System.in);

    private Double  overdraftLimit;
    private Double overDraft;

     public CurrentAccount() {
		super();
	    this.setInterestRate(0.03);
	    
	}

     
	public CurrentAccount(Integer accountNumber, String accountHolderName, Double balance, Double interestRate,
			LocalDate openAccountDate,Double overdraftLimit, Double overDraft) {
		super( accountNumber,  accountHolderName,  balance,  interestRate,
				 openAccountDate);
		this.overdraftLimit = overdraftLimit;
		this.overDraft = overDraft;
	}
    

	public Double getOverdraftLimit() {
		return overdraftLimit;
	}


	public void setOverdraftLimit(Double overdraftLimit) {
		this.overdraftLimit = overdraftLimit;
	}


	public Double getOverDraft() {
		return overDraft;
	}


	public void setOverDraft(Double overDraft) {
		this.overDraft = overDraft;
	}


	@Override
	public void openAccount() {
		// TODO Auto-generated method stub
		
		 System.out.println("==========================================================");
		   System.out.println("To Open Saving Account,Please fill the below Information :");
		   System.out.println("==========================================================");
		   /*System.out.println("Enter Account Number ");
		   Integer accNum=sc.nextInt();*/
		   System.out.println("Enter Account Holder Name ");
		   String accHolderName=sc.nextLine();
		   System.out.println("Enter Balance , You Want to Start With ");
		   Double accBalance=sc.nextDouble();
		   System.out.println("Enter the Over Draft Limit ");
		   Double odlimit=sc.nextDouble();
		   System.out.println("Enter the Overdarft Amount ");
		   Double odamount=sc.nextDouble();
		   
		   
		   this.setAccountNumber(generateAccountNumber());
		   this.setAccountHolderName(accHolderName);
		   this.setBalance(accBalance);
		   this.setOverdraftLimit(odlimit);
		   this.setOverDraft(odamount);
		   this.setOpenAccountDate(LocalDate.now());
		   
		   System.out.println("Mr/Mrs,Miss "+ accHolderName+ " Your Current Account Open Successfully ,Your  Account Number is : " + getAccountNumber());

		
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
		 
		 // balance 50000+overdraft 25000=75000 tempamount
		 Double tempamount=this.getBalance()+this.getOverdraftLimit();
		 //60000 withdraw
		 
		 if(tempamount>withdrawAmount)
		 {
			 if(this.getBalance()>withdrawAmount)
			 {
				 this.setBalance(this.getBalance()-withdrawAmount);
				 System.out.println("Your Transaction is of  "+withdrawAmount+" Successfully complete...!");
			 }
			 else
			 {
				 System.out.println("Your have less balance than withdrawn amount but you can use Overdraft Limit");
				 this.setBalance(this.getBalance()+this.getOverdraftLimit());
				 this.setOverdraftLimit(this.getBalance()-withdrawAmount);
				 this.setBalance(0.0);
			 }
			 
		 }
		 else
		 {
			 System.out.println("You have Insufficient Balance....!");
		 }
		
	}

	@Override
	public void calculateInterest() {
		
		Double interestAmount=this.getBalance()+this.getInterestRate();
		System.out.println("Inetrest on Current Account :: "+interestAmount);
		
	}

	@Override
	public void showAccountTransaction() {
		// TODO Auto-generated method stub
		System.out.println("Hello Mr./Mrs./Miss :: "+this.getAccountHolderName());
	    System.out.println("Having Account Number :: "+this.getAccountNumber());
	    System.out.println("With Balance of :: "+this.getBalance());
	    System.out.println("Overdraft Limit of :: "+this.getOverdraftLimit());
	    System.out.println("Applying Interest Rate on Balance Would Be :: "+this.getInterestRate());
	    System.out.println("Note Your Account Opening Date Was :: "+this.getOpenAccountDate());
	    
		
	}
    

		
		
		    

	}



