package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class TestATM {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Account> createdAccounts = new ArrayList<Account>();
		
		
	//	Account acc1 = new Account(10, "Emir", 150);
//		Account acc2 = new Account(12, "Mirsad", 270);
		
		//createdAccounts.add(acc1);
//		createdAccounts.add(acc1);

		int menuChoice;
		do {
			System.out.print("\nPlease Choose From the Following Options:" 
					+ "\n 1. Create Account \n 2. Deposit"
					+ "\n 3. Withdraw\n 4. Transfer"
					+ "\n 5. Display Created Accounts \n 0. Log Out\n\n");

			menuChoice = input.nextInt();
			if(menuChoice == 1) {
				CreateAccount.createAccount(createdAccounts);
			}
				
			if(menuChoice == 5)
				listOfAccounts(createdAccounts);

			if (menuChoice < 1 || menuChoice > 5) {
				System.out.println("You have tried to select non existing option. Please try again.");
			}
			
		} while (menuChoice != 0);

		
		input.close();
	}


	public static void transferMoney(Account sourceAccount, Account targetAccount, double transferAmount) {
		if (sourceAccount.getBalance() < transferAmount) {
			System.out.println("Sorry, you do not have enough money in your Account.");
			return;
		}
		sourceAccount.setBalance(sourceAccount.getBalance() - transferAmount);
		targetAccount.setBalance(targetAccount.getBalance() + transferAmount);
		System.out.println("Transfer successful!");
	}

	public static void listOfAccounts(ArrayList<Account> createdAccounts) {
		for (Account acc : createdAccounts) {
			System.out.println(acc);

		}
	}

}
