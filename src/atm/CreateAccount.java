package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateAccount {
	
	public static void createAccount(ArrayList<Account> createdAccounts) {
		System.out.println("Please input your new account details.  ");
		//potrebno rijesiti upozorenje za scanner input.close()
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Account number:  ");
		int accountNumber = input.nextInt();
		System.out.print("Account owner name:  ");
		String accountOwner = input.next();
		System.out.print("Account balance:   ");
		double balance = input.nextDouble();		
		Account acc = new Account(accountNumber, accountOwner, balance);
		createdAccounts.add(acc);
			
	}
}
