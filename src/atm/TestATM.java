package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class TestATM {

	public static void main(String[] args) {

		ArrayList<Account> createdAccounts = new ArrayList<Account>();
		Scanner input = new Scanner(System.in);

		int menuChoice;
		do {
			System.out.print("\nPlease Choose From the Following Options:" + "\n 1. Create Account \n 2. Deposit"
					+ "\n 3. Withdraw\n 4. Transfer" + "\n 5. Display Created Accounts \n 0. Log Out\n\n");

			menuChoice = input.nextInt();

			if (menuChoice < 1 || menuChoice > 5) {
				System.out.println("You have tried to select non existing option. Please try again.");
			}

			switch (menuChoice) {
			case 1:
				Actions.createAccount(createdAccounts);
				break;

			case 2:
				Actions.deposit(createdAccounts);
				break;

			case 3:
				Actions.withdrawal(createdAccounts);
				break;

			case 4:
				Actions.transfer(createdAccounts);
				break;

			case 5:
				Actions.listOfAccounts(createdAccounts);
				break;
			}

		} while (menuChoice != 0);

		input.close();
	}

}
