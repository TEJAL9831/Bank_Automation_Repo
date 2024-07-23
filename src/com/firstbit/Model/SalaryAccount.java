package com.firstbit.Model;


import java.time.LocalDate;
import java.util.Scanner;

public class SalaryAccount extends SavingAccount {
	
	    private Scanner sc=new Scanner(System.in);
	      Double salary;
	      LocalDate transactionDate;
	     
	      LocalDate lastTransactionDate;
		public SalaryAccount() {
			super();
			this.setInterestRate(0.05);
		}
		public Double getSalary() {
			return salary;
		}
		public void setSalary(Double salary) {
			this.salary = salary;
		}
		public LocalDate getTransactionDate() {
			return transactionDate;
		}
		public LocalDate getLastTransactionDate() {
			return lastTransactionDate;
		}
		public void setLastTransactionDate(LocalDate lastTransactionDate) {
			this.lastTransactionDate = lastTransactionDate;
		}
		public void setTransactionDate(LocalDate transactionDate) {
			this.transactionDate = transactionDate;
		}
	      
		@Override
		public void openAccount() {
			   System.out.println("==========================================================");
			   System.out.println("To Open Salary Account,Please fill the below Information :");
			   System.out.println("==========================================================");
			  /* System.out.println("Enter Account Number ");
			   Integer accNum=sc.nextInt();*/
			   System.out.println("Enter Account Holder Name ");
			   String accHolderName=sc.nextLine();
			   System.out.println("Enter Balance , You Want to Start With ");
			   Double accBalance=sc.nextDouble();
			   System.out.println("Enter Salary :: ");
			   Double salaryBalance=sc.nextDouble();
			   
			   this.setAccountNumber(generateAccountNumber());
			   this.setAccountHolderName(accHolderName);
			   this.setBalance(accBalance);
			   this.setSalary(salaryBalance);
			   this.setBalance(this.getBalance()+this.getSalary());
			   this.setOpenAccountDate(LocalDate.now());
			   this.setLastTransactionDate(lastTransactionDate);
			
			   System.out.println("Mr/Mrs,Miss "+ accHolderName+ " Your Saving Account Open Successfully ,Your  Account Number is : " + getAccountNumber());

		}

		@Override
		public void depositInAccount() {
			
			System.out.println("Enter the deposite Amount ::");
			Double amount=sc.nextDouble();
			
			// here we write business logic set new balance from adding new amount and print total balance
			this.setBalance(this.getBalance()+amount);
			System.out.println("Total Balance :: "+this.getBalance());
			 
			this.setTransactionDate(LocalDate.now());
			 this.lastTransactionDate = LocalDate.now();
			
		}

		@Override
		public void withdrawFromAccount() {
			
			 System.out.println("Enter the withdraw amount :: ");
			 Double withdrawAmount=sc.nextDouble();
			 	 
			 if(this.getBalance()>withdrawAmount)
			 {
			    
					this.setBalance(this.getBalance()-withdrawAmount);
					System.out.println("Your Transaction is of  "+withdrawAmount+" Successfully complete...!");
					 this.setTransactionDate(LocalDate.now());
					 this.lastTransactionDate = LocalDate.now();
			    
		
			 }
			 else
			 {
				 System.out.println("Insufficient Balance.....!");
			 }

			
		
		}

		
		public void calculateInterest() {
			
			//suppose we have balance is 15000 and interest rate is 0.04
			
			 Double interestAmount=this.getBalance()*this.getInterestRate();
			 System.out.println("Interest  On Salary Account :: "+interestAmount);
			/* this.setBalance(this.getBalance()+interest);
			 System.out.println("After calculating interest balance is "+this.getBalance());*/
			
		}
		
		//SlaryAccount class specific method
		public void showLastTransactionDate()
		{
			System.out.println("Date Of Last Transaction"+this.getTransactionDate());
			 LocalDate currentDate = LocalDate.now();

		        if (currentDate.minusMonths(2).isAfter(lastTransactionDate)) {
		            System.out.println("Account is frozen due to no transaction in the last 2 months.");
		        }
		}

		@Override
		public void showAccountTransaction() {
		
			System.out.println("Hello Mr./Mrs./Miss :: "+this.getAccountHolderName());
		    System.out.println("Having Account Number :: "+this.getAccountNumber());
		    System.out.println("With Balance of :: "+this.getBalance());
		    System.out.println("Total Salary Account Balance :: "+this.getBalance()+this.getSalary());
		    System.out.println("Applying Interest Rate on Balance Would Be :: "+this.getInterestRate());
		    System.out.println("Note Your Slary Account Opening Date Was :: "+this.getOpenAccountDate());
		    
			
		}

}
