package ATM;

import java.util.ArrayList;
import java.util.List;

class Account {
	 private String accountId;
	    private double balance;
	    private ArrayList<BankTransaction> transactions;

	    public Account(String accountId, double initialBalance) {
	        this.accountId = accountId;
	        this.balance = initialBalance;
	        this.transactions = new ArrayList<>();
	    }

	    public String getAccountId() {
	        return accountId;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public ArrayList<BankTransaction> getTransactions() {
	        return transactions;
	    }

	    public void deposit(double amount) {
	        balance += amount;
	        transactions.add(new BankTransaction("Deposit", amount));
	    }

	    public void withdraw(double amount) {
	        if (balance >= amount) {
	            balance -= amount;
	            transactions.add(new BankTransaction("Withdrawal", amount));
	        } else {
	            System.out.println("Insufficient balance.");
	        }
	    }

	    public void transfer(Account destinationAccount, double amount) {
	        if (balance >= amount) {
	            balance -= amount;
	            transactions.add(new BankTransaction("Transfer to " + destinationAccount.getAccountId(), amount));
	            destinationAccount.deposit(amount);
	        } else {
	            System.out.println("Insufficient balance.");
	        }
	    }
	}


