package com.bankaccountproject;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;


public class BankAccount {
	
	private static DecimalFormat df2 = new DecimalFormat("#,###.00");
	
	// TODO set rounding mode, decimal point - limit to 2 places
	
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
	
	private void accountOverview() {
		System.out.println("Account number: " + this.accountNumber);
		System.out.println("Checking account: $" + this.checkingsBalance);
		System.out.println("Savings accoung: $" + this.savingsBalance);
	}
	
	// Getter for checkingsBalance
	private double getCheckingsBalance() {
		//checkingsBalance = Double.parseDouble(df2.format(checkingsBalance));
		return checkingsBalance;
	}
	
	// Getter for savingsBalance
	private double getSavingsBalance() {
		//savingsBalance = Double.parseDouble(df2.format(savingsBalance));
		return savingsBalance;
	}
	
	// Deposit money
	private void depositMoney() {
		System.out.println("Deposit to CHECKINGS or SAVINGS account?");
		Scanner deposit = new Scanner(System.in);
		String accountType = deposit.nextLine();

		Character firstLetter = accountType.toUpperCase().charAt(0);
		
		System.out.println("How much would you like to deposit?");
		Scanner depositAmount = new Scanner(System.in);
		double amount = depositAmount.nextDouble();
		amount = Double.parseDouble(df2.format(amount));
		
		while (!firstLetter.equals('C') || !firstLetter.equals('S')) {	
			if (firstLetter.equals('C')) {
				checkingsBalance += amount;
				System.out.println("$" + String.format("%.2f", amount) + " has been deposited to your checkings account.");
				break;
			}
			else if (firstLetter.equals('S')) {
				savingsBalance += amount;
				System.out.println("$" + String.format("%.2f", amount) + " has been deposited to your saving account.");
				break;
			}
			else {
				System.out.println("Please enter a valid key.");
				accountType = deposit.nextLine();
			}
		}
	}
	
	// Withdraw money
	private void withdrawMoney() {
		System.out.println("Withdraw from CHECKINGS or SAVINGS account?");
		Scanner withdraw = new Scanner(System.in);
		String accountType = withdraw.nextLine();
		
		Character firstLetter = accountType.toUpperCase().charAt(0);
		
		System.out.println("How much would you like to withdraw?");
		Scanner withdrawAmount = new Scanner(System.in);
		double amount = withdrawAmount.nextDouble();
		amount = Double.parseDouble(df2.format(amount));
		
		boolean insufficientFunds = false;
		
		while (!firstLetter.equals('C') || !firstLetter.equals('S') || insufficientFunds == true) {	
			if (firstLetter.equals('C')) {
				checkingsBalance -= amount;
				if (checkingsBalance < 0) {
					insufficientFunds = true;
					System.out.println("Insufficient funds");
					checkingsBalance += amount;
					System.out.println("Please enter a different amount:");
					amount = withdrawAmount.nextDouble();
				}
				else {
					insufficientFunds = false;
					System.out.println("$" + amount + " has been withdrawn from your checkings account.");
					break;
				}
			}
			else if (firstLetter.equals('S')) {
				savingsBalance -= amount;
				if (savingsBalance < 0) {
					insufficientFunds = true;
					System.out.println("Insufficient funds");
					savingsBalance += amount;
					System.out.println("Please enter a different amount:");
					amount = withdrawAmount.nextDouble();
				}
				else {
					insufficientFunds = false;
					System.out.println("$" + amount + " has been withdraw from your saving account."); 
					break;
				}
			}
			else {
				System.out.println("Please enter a valid key.");
				accountType = withdraw.nextLine();
			}
		}
	}
	
	// TODO separate checkings and savings balance, ask user
	private void checkBalance() {
		Scanner checkBalance = new Scanner(System.in);
		System.out.println("Account Number: " + accountNumber + "\nCheck your balance for CHECKINGS, SAVINGS, or BOTH?");
		
		Character userResponse = checkBalance.nextLine().toUpperCase().charAt(0);
		
		while (!userResponse.equals('C') || !userResponse.equals('S') || !userResponse.equals('B')) {
			
			if (userResponse.equals('C')) {
				System.out.println("Your checkings account balance is $" + checkingsBalance);
				break;
			}
			else if (userResponse.equals('S')) {
				System.out.println("Your savings account balance is $" + savingsBalance);
				break;
			}
			else if (userResponse.equals('B')) {
				System.out.println("Your checkings account balance is $" + checkingsBalance);
				System.out.println("Your savings account balance is $" + savingsBalance);
				break;
			}
			else {
				System.out.println("Please ender a valid response.");
				userResponse = checkBalance.nextLine().toUpperCase().charAt(0);
			}
			
		}
		
	}

	
	
	
	
	public static void main(String[] args) {
		
		// TODO
		// - create entry point option for user to choose:
		//   deposit, withdraw, check balance
		// - option for user to do something else or end transaction
		
		BankAccount client1 = new BankAccount();
		client1.getAccountNumber();
		BankAccount client2 = new BankAccount();
		client2.getAccountNumber();
		
//		client1.depositMoney();
//		client1.depositMoney();
//		client1.withdrawMoney();
//		client1.checkBalance();
		client2.depositMoney();
		client2.withdrawMoney();
		client2.checkBalance();
		System.out.println("\n\n");
		client2.accountOverview();
		
		
	}

}
