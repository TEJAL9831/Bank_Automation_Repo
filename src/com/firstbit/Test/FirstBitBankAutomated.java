package com.firstbit.Test;

import java.util.Scanner;

import com.firstbit.Exception.AccountException;
import com.firstbit.Factory.AccountObjectFactory;
import com.firstbit.Model.Account;
import com.firstbit.Model.LoanAccount;
import com.firstbit.Model.SalaryAccount;

public class FirstBitBankAutomated {

	public static void main(String[] args) throws AccountException {
	
		Scanner scanner = new Scanner(System.in);
        Account account;

        while (true) {
        	System.out.println("=====================================================================================");
        	System.out.println("                             Welocome to FisrtBit-Automated-Bank         ");
        	System.out.println("=====================================================================================");
           
        	System.out.println("Choose an account or 'exit' to quit:");
            String accountTypeChoice = scanner.nextLine();

            switch (accountTypeChoice.toLowerCase()) {
                case "saving":
                case "current":
                case "loan":
                case "salary":
                    account = AccountObjectFactory.getAccountObject(accountTypeChoice);
                    account.openAccount();

                    while (true) {
                        System.out.println("Choose an action/process (deposit/withdraw/calculateInterest/showTransaction/showTransactionDate) or 'back' to go back:");
                        String actionChoice = scanner.nextLine();

                        switch (actionChoice.toLowerCase()) {
                            case "deposit":
                                account.depositInAccount();
                                break;
                            case "withdraw":
                                account.withdrawFromAccount();
                                break;
                            case "calculateinterest":
                                account.calculateInterest();
                                break;
                            case "showLastTransactionDate":
                            	break;
                            case "showtransaction":
                                account.showAccountTransaction();
                                break;
                            case "back":
                                break;
                           
                            default:
                                System.out.println("Invalid choice. Please enter a valid action or 'back'.");
                        }

                        if ("back".equalsIgnoreCase(actionChoice)) {
                            break; // Exit the inner switch-case and go back to the account type choice
                        }
                    }
                    break;

                case "exit":
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0); // Terminate the program
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid Account Type or 'exit'.");
            }
        }
	}

}
