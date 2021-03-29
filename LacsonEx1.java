import java.util.Scanner;
import java.util.Random;

public class LacsonEx1 {
	public static void main(String[] args) {
		String menu;
		do { // do while menu != reset
			// get user input for table dimension
			Scanner scan = new Scanner(System.in);

			System.out.print("\nEnter number of rows: ");
			int row = scan.nextInt();

			System.out.print("Enter number of columns: ");
			int col = scan.nextInt();
			// ====

			
			// store random strings in table
			Generator generator = new Generator() ;
			String[][] table = new String [row][col];
			for (int rowCount = 0; rowCount < row; rowCount++) {
				for (int colCount = 0; colCount < col; colCount++) {
					table[rowCount][colCount] = generator.threeCharGenerator();
					System.out.print(table[rowCount][colCount] + "  "); 
				}
				System.out.println();
			}
			// ====

			// menu
			System.out.print("\nMenu:\nSearch\nEdit\nPrint\nReset\nExit\n\n");
			System.out.print("Choose an option: ");
			scan.nextLine();
			menu = scan.nextLine().toLowerCase();

			switch (menu) {
				case "search":
					System.out.print("Input search character/s: ");
					String searchString = scan.nextLine();
					System.out.print("Search String: " + searchString + "\n");

					int tableOccurs = 0;
					int cellOccurs = 0;
					int inTable = 0;
					for (int rowCount = 0; rowCount < row; rowCount++) {
						for (int colCount = 0; colCount < col; colCount++) {
							if (table[rowCount][colCount].contains(searchString)) {
								tableOccurs = 1;
								inTable = 1;
								if (tableOccurs > 0) {
									System.out.printf("Found %s on (%d,%d)", searchString, rowCount, colCount);
									tableOccurs = 0;

									int lastIndex = 0;
									while  (lastIndex != -1) {
										lastIndex = table[rowCount][colCount].indexOf(searchString, lastIndex);

										if (lastIndex != -1) {
											cellOccurs++;
											lastIndex += searchString.length();
										}
									}
									System.out.println(" with " + cellOccurs + " occurences");
									cellOccurs = 0;
								}
							}
						}
					}	

					if (inTable != 1) System.out.println("Search String not found.");

					break;

				case "edit":
					System.out.print("Specify row index to update: ");
					int rowEdit = scan.nextInt();
					System.out.print("Specify column index to update: ");
					
					int colEdit = scan.nextInt();
					System.out.printf("Replace %s at (%d,%d) with: ", table[rowEdit][colEdit], rowEdit, colEdit);
					scan.nextLine();
					table[rowEdit][colEdit] = scan.nextLine();
					menu = "print";

				case "print":
					System.out.println();
					for (int rowCount = 0; rowCount < row; rowCount++) {
						for (int colCount = 0; colCount < col; colCount++) {
							System.out.print(table[rowCount][colCount] + "  "); 
						}
						System.out.println();
					}					
					break;

				case "reset":
					break;

				case "exit":
					System.exit(0);
					break;

				default:
					System.out.println("Not a valid option.");
					menu = "reset";
			}
			// menu ===
		}
		while (menu.equals("reset")); // do while end
	}

	// generate 3 random ASCII characters
	// private static String threeCharGenerator(){
	// 	Random random = new Random();
	// 	String cell = new String(random.ints(3, 32, 127).toArray(), 0, 3);
	// 	return cell;
	// }
	// ====
}