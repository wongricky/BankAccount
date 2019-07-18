package com.bankaccountproject;
import java.util.Scanner;

public class BankAccount {
	
	public long accountNumber;
	public double checkingsBalance = 0;
	public double savingsBalance= 0;
	public static int numberOfAccounts = 0;
	public static double totalMoney = 0;
	
	// Create random 10 digit account numbers
	private void getAccountNumber() {
		this.accountNumber = (long)(Math.random()*1000000000+1000000000);
		numberOfAccounts++;
	}
	
	private void totalMoney() {
		System.out.println("Account number: " + this.accountNumber);
		System.out.println("Checking account: $" + this.checkingsBalance);
		System.out.println("Savings accoung: $" + this.savingsBalance);
	}
	
	// Getter for checkingsBalance
	private double getCheckingsBalance() {
		return checkingsBalance;
	}
	
	// Getter for savingsBalance
	private double getSavingsBalance() {
		return savingsBalance;
	}
	
	// Deposit money
	private void depositMoney(double amount) {
		System.out.println("Deposit to which account: 'C' for checkings / 'S' for savings");
		Scanner deposit = new Scanner(System.in);
		String accountType = deposit.nextLine();
		while (!accountType.equals("C") || !accountType.contentEquals("c") || !accountType.equals("S") || !accountType.contentEquals("s")) {	
			if (accountType.equals("C") || accountType.equals("c")) {
				checkingsBalance += amount;
				System.out.println("The amount of " + amount + " has been deposited to your checkings account.");
				break;
			}
			else if (accountType.equals("S") || accountType.contentEquals("s")) {
				savingsBalance += amount;
				System.out.println("The amount of " + amount + " has been deposited to your saving account.");
				break;
			}
			else {
				System.out.println("Please enter a valid key.");
				accountType = deposit.nextLine();
			}
		}
	}
	
	// Withdraw money
	private void withdrawMoney(double amount) {
		System.out.println("Withdraw from which account: 'C' for checkings / 'S' for savings");
		Scanner withdraw = new Scanner(System.in);
		String accountType = withdraw.nextLine();
		while (!accountType.equals("C") || !accountType.contentEquals("c") || !accountType.equals("S") || !accountType.contentEquals("s")) {	
			if (accountType.equals("C") || accountType.equals("c")) {
				checkingsBalance -= amount;
				if (checkingsBalance < 0) {
					System.out.println("Insufficient funds");
					checkingsBalance += amount;
				}
				else {
					System.out.println("The amount of " + amount + " has been withdrawn from your checkings account.");
				}
				break;
			}
			else if (accountType.equals("S") || accountType.contentEquals("s")) {
				savingsBalance -= amount;
				if (savingsBalance < 0) {
					System.out.println("Insufficient funds");
					savingsBalance += amount;
				}
				else {
					System.out.println("The amount of " + amount + " has been withdraw from your saving account."); 
				}
				break;
			}
			else {
				System.out.println("Please enter a valid key.");
				accountType = withdraw.nextLine();
			}
		}
	}
	
	// Check balance: savings and checkings
	private void checkBalance() {
		System.out.println("Your checks account balance is " + checkingsBalance);
		System.out.println("Your savings account balance is " + savingsBalance);
		
	}

	
	
	
	
	public static void main(String[] args) {
		BankAccount client1 = new BankAccount();
		client1.getAccountNumber();
		BankAccount client2 = new BankAccount();
		client2.getAccountNumber();
		
		client1.depositMoney(300.00);
		client1.depositMoney(625.75);
		client1.withdrawMoney(150.00);
		client1.checkBalance();
		client2.depositMoney(400);
		client2.checkBalance();
		System.out.println("\n\n");
		client1.totalMoney();
		client2.totalMoney();
		
		System.out.println("Total number of accounts " + numberOfAccounts);
		
	}

}
