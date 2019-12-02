package atm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataExport {

	public static void exportAccounts(ArrayList<Account> createdAccounts) throws IOException {

		Path path = Paths.get("createdAccounts");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}
		BufferedWriter writer = Files.newBufferedWriter(path);
		String createdAccountsDetails = "";
		for (Account acc : createdAccounts) {
			createdAccountsDetails = acc.toString();
			writer.write(createdAccountsDetails + "");
			writer.newLine();

		}
		writer.close();
	}

//	public static void exportTransactions(ArrayList<Transaction> createdTransactions) {
//		for (trans : completedTransactions) {
//			System.out.println(trans);
//		}
//	}

}
