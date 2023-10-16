package ATM;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		 	Bank bank = new Bank();
	        AccountHolder accountHolder = new AccountHolder("user123", "1234");
	        Account account1 = new Account("123456", 1000.0);
	        Account account2 = new Account("654321", 500.0);
	        bank.addAccount(account1);
	        bank.addAccount(account2);
	        
	        ATM atm = new ATM(accountHolder,bank);
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter your user ID: ");
	        String userId = scanner.next();
	        System.out.print("Enter your PIN: ");
	        String pin = scanner.next();
	        
	        if (userId.equals(accountHolder.getUserId()) && pin.equals(accountHolder.getPin())) {
	            boolean quit = false;
	            
	            while (!quit) {
	                System.out.println("\nATM Menu:");
	                System.out.println("1. Show Transaction History");
	                System.out.println("2. Withdraw");
	                System.out.println("3. Deposit");
	                System.out.println("4. Transfer");
	                System.out.println("5. Check Balance");
	                System.out.println("6. Quit");
	                System.out.print("Enter your choice: ");
	                int choice = scanner.nextInt();
	                
	                switch (choice) {
	                    case 1:
	                        atm.showTransactionHistory(account1);
	                        break;
	                    case 2:
	                        System.out.print("Enter withdrawal amount: ");
	                        double withdrawalAmount = scanner.nextDouble();
	                        atm.withdraw(account1, withdrawalAmount);
	                        break;
	                    case 3:
	                        System.out.print("Enter deposit amount: ");
	                        double depositAmount = scanner.nextDouble();
	                        atm.deposit(account1, depositAmount);
	                        break;
	                    case 4:
	                        System.out.print("Enter destination account ID: ");
	                        String destinationAccountId = scanner.next();
	                        Account destinationAccount = bank.getAccountById(destinationAccountId);
	                        if (destinationAccount != null) {
	                            System.out.print("Enter transfer amount: ");
	                            double transferAmount = scanner.nextDouble();
	                            atm.transfer(account1, destinationAccount, transferAmount);
	                        } else {
	                            System.out.println("Destination account not found.");
	                        }
	                        break;
	                    case 5:
	                        double balance = atm.checkBalance(account1);
	                        System.out.println("Account balance: " + balance);
	                        break;
	                    case 6:
	                        quit = true;
	                        System.out.println("Thank you for using the ATM. Goodbye!");
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Please enter a valid option.");
	                }
	            }
	        } else {
	            System.out.println("Invalid user ID or PIN. Access denied.");
	        }
	        
	        scanner.close();
	    }
	
    }

