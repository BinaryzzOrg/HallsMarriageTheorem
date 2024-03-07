public class LinkedStructure {
	// == FIELD VARIABLE == //
	public Gift giftHead;
	public Person personHead;
	private int giftCount = 0;
	private int personCount = 0;
	String[][] match = new String[2][3];

// ========== BIPARTITE ========== //
	/*
	 * 
	 */
	public void insertPerson(String name) {
		if (personCount > 10) {
			System.out.print("Notice: \033[3mMaximum capacity of People reached (" + personCount + "/10)\033[0m");
		}

		if (personHead == null) {
			this.personHead = new Person(name);
			return;
		}
		Person tempPerson = personHead;
		while (tempPerson.getNext() != null) {
			tempPerson = tempPerson.getNext();
		}
		tempPerson.setNext(new Person(name));
	}// end method

	/*
	 * 
	 */
	public void insertGift(String name) {
		if (giftCount > 10) {
			System.out.print("Notice: \033[3mMaximum capacity of Gifts reached (" + giftCount + "/10)\033[0m");
		}

		if (giftHead == null) {
			this.giftHead = new Gift(name);
			return;
		}
		Gift tempGift = giftHead;
		while (tempGift.getNext() != null) {
			tempGift = tempGift.getNext();
		}
		tempGift.setNext(new Gift(name));
	}// end method

	/*
	 * 
	 */
	public void insertPreferredGift() {
		Person tempPerson = personHead;
		if (tempPerson == null) {
			System.out.print("Notice: \033[3mNo person is currently on the graph"
					+ "\n  Please add persons before adding preferred gifts.\033[0m \n");
			return;
		} // end if

		while (tempPerson != null) {
			System.out.print("\n:: How many Gifts does " + tempPerson.getName() + " prefer?\nUserInput%> ");
			int numPrefGift = Main
					.checkUserInputMenu("\n:: How many Gifts does " + tempPerson.getName() + " prefer?\nUserInput%> ");
			System.out.print("\n:: Enter names of the Gifts.");
			for (int i = 0; i < numPrefGift; i++) {
				System.out.print("\nUserInput" + i + "> ");
				tempPerson.insertPrefGift(new Gift(Main.checkUserInput("\nEnter names of the Gifts.\nUserInput%> ")));
			} // end for
			tempPerson = tempPerson.getNext();
		} // end while
		displayPersonWithGift();
	}// end method

	/*
	 * 
	 */
	public void removeGift(Person person, String name) {
		Gift mainGift = person.getPrefGift();
		Gift tempGift = mainGift;

		if (tempGift.getName().equalsIgnoreCase(name)) {
			System.out.println("test1");
			person.setPrefGift(mainGift);
			return;
		} // end if

		while (tempGift != null) {
			if (tempGift.getName().equalsIgnoreCase(name)) {
				System.out.println("test2");
				tempGift.setNext(tempGift.getNext());
			} // end if
			tempGift = tempGift.getNext();
		} // end while
		mainGift = tempGift;
		person.setPrefGift(mainGift);
	}// end method

	/*
	 * 
	 */
	public void match() {
		Person tempPerson = personHead;
		while (tempPerson != null) {
			removeGift(tempPerson, "Ball");
			tempPerson = tempPerson.getNext();
		} // end while
	}// end method

// ========== OTHER METHODS =======/ 
	/*
	 * 
	 */
	public void displayPersonWithGift() {
		Person tempPerson = personHead;
		if (!isPersonAvailable(tempPerson)) {
			System.out.print("Notice: \033[3mNo person is currently on the graph"
					+ "\n  Please add people to the graph first..\033[0m \n");
		}

		while (tempPerson != null) {
			System.out.print(tempPerson.getName() + " --> | ");
			Gift tempGift = tempPerson.getPrefGift();
			while (tempGift != null) {
				System.out.print(tempGift.getName() + " | ");
				tempGift = tempGift.getNext();
			}
			System.out.println();
			tempPerson = tempPerson.getNext();
		} // end while
		System.out.println();
	}// end method

	/*
	 * 
	 */
	public void displayPerson() {
		Person tempPerson = personHead;
		if (tempPerson == null) {
			System.out.println("");
			return;
		}
		System.out.print(":: Persons: \n| ");

		while (tempPerson != null) {
			System.out.print(tempPerson.getName() + " | ");
			tempPerson = tempPerson.getNext();
		}
		System.out.println();
	}// end method

	/*
	 * 
	 */
	public void displayGift() {
		System.out.print(":: Gift: \n| ");
		Gift tempGIft = giftHead;
		while (tempGIft != null) {
			System.out.print(tempGIft.getName() + " | ");
			tempGIft = tempGIft.getNext();
		}
		System.out.println();
	}// end method

	/*
	 * 
	 */
	public boolean isPersonAvailable(Person person) {
		if (person == null) {
			return false;
		} // end if
		return true;
	}// end method

}// end class
