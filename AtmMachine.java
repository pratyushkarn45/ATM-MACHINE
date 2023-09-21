package basics;
import java.util.*;
import java.util.Scanner;



public class AtmMachine {
	
	
	public static void main(String[] args) {
		Account obj = new Account();
		obj.checkPin();

	}

}

class Account {
	
	int balance=0;
	int previousTransaction;
	int PIN=1234;
	int maxAttempts=3;
    void checkPin() {
		
		System.out.println("Enter PIN ");
		Scanner scanner = new Scanner(System.in);
		int enteredpin= scanner.nextInt();
		
		for(int attempts=1;attempts<=maxAttempts;attempts++) {
		if (enteredpin == PIN ) {
			showMenu();
			break;
	   }
		else {
			System.out.println("Enter Valid Pin");
			 enteredpin= scanner.nextInt();
				 
			 }
	
		}
		
    
}
	void Deposit(int amount) {
		if(amount !=0) {
			 balance = balance + amount;
			 previousTransaction = amount;
		}
	}
	void withdraw(int amount) {
		if(amount !=0) {
			balance = balance - amount;
			previousTransaction = -amount;

	}
}
	 void transfer(int amount, Account recipient) {
	        if (amount != 0 && amount <= balance) {
	            balance = balance - amount;
	            recipient.balance = recipient.balance + amount;
	            System.out.println("Amount transferred: " + amount);
	            previousTransaction = -amount;
	        } else {
	            System.out.println("Transfer failed. Invalid amount or insufficient balance.");
	        }
	    }
	 
	void getPreviousTransaction() {

		if(previousTransaction > 0) {
			System.out.println("Deposited:" + previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("withdrawn:" +Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction occured");
		}
	}
 
	public void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
	
		
		System.out.println("A : Check Account Balance");
		System.out.println("B : Deposit Money");
		System.out.println("C : Withdraw Money");
		System.out.println("D : Transaction History");
		System.out.println("E : Transfer Amount");
		System.out.println("F : Quit");
	
	
	
	 do {
			System.out.println("************************************");
			System.out.println("Enter your Option");
			System.out.println("************************************");
		
		    option = scanner.next().charAt(0);
			
			
			switch(option) {
			case 'A':
				System.out.println("------------------------------------");
				System.out.println("Account Balance= " +balance);
				System.out.println("------------------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("------------------------------------");
				System.out.println("Enter an amount to deposit");
				System.out.println("------------------------------------");
				int amount = scanner.nextInt();
				Deposit(amount);
				System.out.println("Amount deposited in the account = "+amount);
				System.out.println("\n");
				break;
			case 'C':
				System.out.println("------------------------------------");
				System.out.println("Enter an amount to withdraw");
				System.out.println("------------------------------------");
				int amount2 = scanner.nextInt();
                
				if(amount2>balance){
				System.out.println("Error occured !!\n");
                System.out.println("Please enter the amount which is lesser than or equal to your balance!!\n");
				}
				else {
				withdraw(amount2);
				System.out.println("Amount withdrawn from the account = "+amount2);
				System.out.println("\n");
				}
				break;

			case 'D':
				System.out.println("------------------------------------");
				System.out.println("Your previous transaction status is: \n ");
				getPreviousTransaction();
				System.out.println("--------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E' :
			     System.out.println("------------------------------------");
                 System.out.println("Enter the recipient's account balance: ");
                 int recipientBalance = scanner.nextInt();
                 Account recipientAccount = new Account();
                 recipientAccount.balance = recipientBalance;
                 System.out.println("Enter the amount to transfer: ");
                 int transferAmount = scanner.nextInt();
                 transfer(transferAmount, recipientAccount);
                 System.out.println("\n");
                 break;
				
			case 'F':
			System.out.println("Preparing to exit...");
			break;
				
				default:
					System.out.println("Invalid option!! please enter one of the valid options: A,B,C,D,E,F...");
					break;
			}
	}
	 while(option != 'F');
		System.out.println("Thank you for using our services......!!");
}
}
	






