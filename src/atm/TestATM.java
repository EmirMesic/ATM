package atm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestATM {

	public static void main(String[] args) throws IOException {

		ArrayList<Account> createdAccounts = new ArrayList<Account>();
//		ArrayList<Actions> completedActions = new ArrayList<Actions>();

		Scanner input = new Scanner(System.in);
		Account acc = new Account(1, "Admin", 100);
		createdAccounts.add(acc);
		
		int menuChoice = 0;
		boolean continueInput = true;
		do {
			try {
				System.out.print("\nPlease choose one of the following options:" + "\n 1. Create Account \n 2. Deposit"
						+ "\n 3. Withdraw\n 4. Transfer" + "\n 5. Display Created Accounts \n 0. Log Out\n\n");

				menuChoice = input.nextInt();

				if ((menuChoice < 1 || menuChoice > 5) && menuChoice != 0) {
					throw new InputMismatchException();
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
			} catch (InputMismatchException ex) {
				System.out.println("You have tried to select non existing option, try again.");
				input.nextLine();
			}

		} while (continueInput);

		System.out.println("Thank you!");

		input.close();
	}

}
