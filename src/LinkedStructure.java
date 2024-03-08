import java.util.*;

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
			return;
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
	 * Remove gift method removes the specified gift in the list of preferred gifts during the matching process 
  	 * mainGift is for storing the person's preferred gift, temp gift is for traversing the list, and previous gift
    	 * is for keeping the reference of the headthat is used in the while loop
      	 * the first two if condition is for no more gift left and the gift to delete is at the head
	 * while loop is for deleting at the node after the beginning to the end
  	 * is tempGift is not null move the pointer of the previous gift to the next of the tempGift to loose the reference
    	 * then update the preferred gift of the person
	 */
	public void removeGift(Person person, String name) {
		Gift mainGift = person.getPrefGift();
		Gift tempGift = mainGift;
		Gift previousGift = null;

		if (tempGift == null) { 
			return;
		}

		if (tempGift.getName().equalsIgnoreCase(name)) {
			person.setPrefGift(tempGift.getNext());
			return;
		}

		while (tempGift != null && !tempGift.getName().equalsIgnoreCase(name)) {
			previousGift = tempGift;
			tempGift = tempGift.getNext();
		}
		
		if (tempGift != null) {
			previousGift.setNext(tempGift.getNext());
			person.setPrefGift(mainGift);
		}
	}

	/*
 	 * match method is for matching the person with the gifts optimally
   	 * the 2D array named match is for storing the matches person with the gift and printing it later
     	 * the nested while loop gets the perferred gift of the person first then keep the reference of the current
         * person before traversing to other persons, afterwards store the name and gift it has been matches with in the array
	 * then perform removal of the matched gift in the preferred gift of all the other persons because it has been taken
  	 * continue it until it reaches the last person in the outer while loop.
    	 * if the 2d array has a null value inside it should print no feasible solution since not all persons have a gift
      	 * else print it all.
  	 */
	public void match() {
		Person tempPerson = personHead;
		Person currentPerson;
		String[][] match = new String[2][getPersonListSize()];

		System.out.println("Performing Optimal Matching...");

		int personIndex = 0;
		while (tempPerson != null) {

			Gift personGift = tempPerson.getPrefGift();
			currentPerson = tempPerson;
			if (personGift != null) {
				match[0][personIndex] = tempPerson.getName();
				match[1][personIndex] = personGift.getName();

				while (tempPerson != null) {
					removeGift(tempPerson, personGift.getName());
					tempPerson = tempPerson.getNext();
				}
			}
			tempPerson = currentPerson.getNext();
			personIndex++;
		}

		String optimallyMatched = "";
		for (int i = 0; i < match[0].length; i++) {
			if (match[0][i] == null && match[1][i] == null) {
				System.out.println("No feasible Solution.");
				return;
			}
			optimallyMatched += match[0][i] + " -> " + match[1][i] + "\n";
		}
		System.out.println(optimallyMatched);
	}
/*
 * 
 * 
 */
	public int getPersonListSize() {

		Person tempPerson = personHead;
		int count = 0;
		while (tempPerson != null) {
			count++;
			tempPerson = tempPerson.getNext();
		}
		return count;
	}

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
