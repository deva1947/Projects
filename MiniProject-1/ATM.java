package ATM;

import java.util.Scanner;

import ATM.Bank;

public class ATM {
	private AccountHolder currentAccountHolder;
    private Bank currentBank;

    public ATM(AccountHolder accountHolder, Bank bank) {
        this.currentAccountHolder = accountHolder;
        this.currentBank = bank;
    }

    public void showTransactionHistory(Account account) {
        for (BankTransaction transaction : account.getTransactions()) {
            System.out.println(transaction.getDescription() + ": " + transaction.getAmount());
        }
    }

    public void withdraw(Account account, double amount) {
        account.withdraw(amount);
    }

    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public void transfer(Account sourceAccount, Account destinationAccount, double amount) {
        sourceAccount.transfer(destinationAccount, amount);
    }

    public double checkBalance(Account account) {
        return account.getBalance();
    }
}

