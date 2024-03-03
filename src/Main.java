import java.util.Scanner;

public class Main {
	// field variables
	// private static HashTable hashTable = new HashTable();

	public static void main(String[] args) {
		Menu();
	}// end method

	// == GETTER SETTERS == //
	// getter setter for

	/*
	 * The PrintMenuChoices method returns a formatted string for MainMenu. This
	 * formatted string is displayed to the user when they run the code for the
	 * first time. The method is also passed as a parameter to other methods that
	 * use the 'prompt' String.
	 */
	public static String PrintMenuChoices() {
		String MenuChoicesAsString =
		//@formatter:off
								"\n" + 
								"       {MainMenu}\n"+ 
								"━━━━━━━━━━━━━━━━━━━━━━━━━\n"+ 
								"┃ 【 1 】 Add Persons \n" +
								"┃ 【 2 】 Add Gifts \n" + 
								"┃ 【 3 】 Add Preferred Gift \n" + 
								"┃ 【 4 】 Print Matches \n" + 
								"┃ 【 5 】 Exit \n" + 
								"━━━━━━━━━━━━━━━━━━━━━━━━━\n" + 
								"》 ";
				//@formatter:on
		return MenuChoicesAsString;
	}// end method

	/*
	 * The MenuChoices method contains the following operations: Add, ViewHashTable,
	 * and Exit. This method calls the PrintMenuChoices that prints out the choices
	 * for modifying the HashTable that is chosen by the user. MenuChoices method
	 * also handles miss inputs of the user and loops if it detects one.
	 */
	private static BGraph bGraph = new BGraph();
	private static int defaultLoopCount = 10;

	public static void Menu() {
		System.out.print(PrintMenuChoices());

		switch (CheckUserInput(PrintMenuChoices())) {
		case 1: {// Add Persons
			for (int i = 0; i < defaultLoopCount; i++) {
				System.out.print("\n:: Enter a person name. \nUserInput%> ");
				Person inputPerson = new Person(checkUserInput("\n:: Enter the string to search. \nUserInput%> "));
				bGraph.addPerson(inputPerson);
			} // end for

			// == debug code == //
			System.out.println("== Persons currently in array ==");
			bGraph.printPersonArray();
			// == end of debug == //
			break;
		}
		case 2: {// Add Gifts
			for (int i = 0; i < defaultLoopCount; i++) {
				System.out.print("\n:: Enter a Gift. \nUserInput%> ");
				Gift inputGift = new Gift(checkUserInput("\n:: Enter a Gift. \nUserInput%> "));
				bGraph.addGift(inputGift);
			} // end for

			// == debug code == //
			System.out.println("== Gifts currently in array ==");
			bGraph.printGiftsArray();
			// == end of debug == //
			break;
		}
		case 3: {// Add Preferred Gifts
//			Person inputPerson = bGraph.findPerson(checkUserInput("\n:: Enter a person name. \nUserInput%> "));
//			boolean condition = true;
//			do {
//				bGraph.addEdge(, );
//			} while (condition != true);

			break;
		}
		case 4: {// Print Matches
			break;
		}
		case 5: {// Exit
			System.out.println("「Exiting now...」");
			System.exit(0);
			break;
		}
		default:
			// @formatter:off
			System.out.println("\n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Error: \n" +
					"┇ Input is not a valid Menu choice. \n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
					"┇ Msg: \n" +
					"┇ \033[3mPlease enter only 1 to _ as input\033[0m \n" +
					"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃");
			// @formatter:on
			break;
		}// end method

		Menu();
	}// end method

	/*
	 * The CheckUserInput method scans the user's input and checks if it is an
	 * integer. If the input is an integer, it is stored in the 'value' variable and
	 * returns it. If the input is not an integer, an error message is displayed,
	 * and the user is prompted to enter an integer value. The 'prompt' parameter is
	 * used for different scenarios of printing needed for certain menus.
	 */
	public static int CheckUserInput(String prompt) {
		Scanner sc = new Scanner(System.in);

		if (sc.hasNextInt()) {
			int value = sc.nextInt();
			return value;
		} // end if

		// @formatter:off
			System.out.println("\n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Error: \n" +
						"┇ Input is not an integer value. \n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n" +
						"┇ Msg: \n" +
						"┇ \033[3mPlease enter INTEGER input only\033[0m \n" +
						"⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃⁃\n");
		// @formatter:on
		System.out.print(prompt);
		return CheckUserInput(prompt);
	}// end if

	/*
	 * The CheckUserInputMenu method scans the user's input and checks if it is an
	 * integer. If the input is an integer, it is stored in the 'value' variable and
	 * returns it. If the input is not an integer, an error message is displayed,
	 * and the user is prompted to enter an integer value. The 'prompt' parameter is
	 * used for different scenarios of printing, and the 'isNotAllowed' parameter is
	 * for the setSize method. If 'isNotAllowed' is passed a 'true', then the
	 * checkUserMenu method would not accept any value that is less than 15.
	 */
	// TLDR - METHOD FOR DEALING WITH INTEGER INPUT
	static Scanner sc;

	public static int checkUserInputMenu(String prompt) {
		sc = new Scanner(System.in);

		if (sc.hasNextInt()) {
			int value = sc.nextInt();
			return value;
		} // end if

		System.out.println(printCustomError("integer"));

		System.out.print(prompt);
		return checkUserInputMenu(prompt);
	}// end if

	/*
	 * The CheckUserInput is an overload of CheckUserMenu method, This method scans
	 * the user's input and checks if it is a string. If the input is a string, it
	 * is stored in the 'input' variable and returns it. If the input is not a
	 * string, an error message is displayed, and the user is prompted to enter a
	 * string value. The 'prompt' parameter is used for different scenarios of
	 * printing
	 */
	// TLDR - METHOD FOR DEALING WITH STRING INPUT
	public static String checkUserInput(String prompt) {
		sc = new Scanner(System.in);

		if (!sc.hasNextInt()) {
			String input = sc.nextLine();
			return input;
		} // end if

		System.out.println(printCustomError("string"));

		System.out.print(prompt);
		return checkUserInput(prompt);
	}// end if

	/*
	 * The printCustomError is exclusively used by checkUserInput, and
	 * checkUserInputMenu for printing their errors, but this method can by used by
	 * other methods if needed. This method has a parameter called 'type' for
	 * specify what data is needed to be inputed on a method that calls this.
	 */
	public static String printCustomError(String type) {
		// @formatter:off
		return "\n" +
			"Warning: Input is not a "+ type +" value. \n\n" +
			"Notice: \033[3mPlease only enter a "+ type +" value.\033[0m \n";
		// @formatter:on
	}// end method
}// end method