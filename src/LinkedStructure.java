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
	 * This is a method for inserting a new node in the linklist of Person object. We have a maximum number of persons
	 * which is 10, so if the number of persons is already 10 we display an error message that the user cannot insert 
	 * another person and we exit the method. If the "personHead" or the head in the person list is null, create a new node 
	 * and make it the head of the list and exit the method. Else, we traverse in the list until we  get the last node, 
	 * connect the last node and the new node by calling the method setNext(), the new node will become the last node 
	 * of the list. Hence, creating a list of persons.
	 * 
	 * Displaying all the persons in the Person list.
	 * 
	 */
	public void insertPerson(String name) {
		if (personCount == 10) {
			System.out.print("Notice: \033[3mMaximum capacity of People reached (" + personCount + "/10)\033[0m");
			return;
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
	 * This is a method for inserting a new node in the linklist of Gift object. We have a maximum number of gifts
	 * which is 10, so if the number of gifts is already 10 we display an error message that the user cannot insert 
	 * another gift and we exit the method. If the "giftHead" or the head in the gift list is null, create a new node 
	 * and make it the head of the list and exit the method. Else, we traverse in the list until we  get the last node, 
	 * connect the last node and the new node by calling the method setNext(), the new node will become the last node 
	 * of the list. Hence, creating a list of gifts. 
	 * 
	 * Displaying all the gifts in the Gift list.
	 */
	public void insertGift(String name) {
		if (giftCount == 10) {
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
	 * Each Person object have a linklist of their preferred gifts called "prefGift". This method is for inserting 
	 * the preferred gifts of each person in our referenced linklist.
	 * If we don't have any person in our list of Person, we display an error message saying that the user need 
	 * to add a person first before inserting preferred gifts. 
	 * Else, we traverse the list of person, asking each person how many gifts they preferred. The user needs to 
	 * enter all the preferred gift names. The gift names are checked if the names are in the list of gifts. If 
	 * the gift name is not on the list of gift, we display an error message and asking for another name. After 
	 * checking, if valid, it will store in the person's list of preferred gifts.
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
		displayPersonWithPrefGift();
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
	 * Method for getting the number of person in the list of Person. creating variable count
	 * that will increment when traversing through the list. It will continue to increment until
	 * it gets to the last node of the list. The new value of count will return after;
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
	 * Method for displaying the Person along with their preferred gift. We first traverse the person list, 
	 * getting the name of the current Person node and print its name using the method getName(). After that, 
	 * we need to traverse the current Persons's preferred gifts by getting its reference head node "prefGift".
	 * Traverse all the preferred gifts and print each gift names. Then we move on to the next person on the list
	 * and do the same way as the current Person until we get all the person and their preferred gifts names to print.
	 */
	public void displayPersonWithPrefGift() {
		Person tempPerson = personHead;
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
	 * Method for displaying the person list. Each time we traverse the person, we print its name. 
	 * It will traverse all the way until to the last node. The while loop will stop if we meet a null
	 * node.
	 */
	public void displayPerson() {
		System.out.print(":: Persons: \n| ");
		Person tempPerson = personHead;
		while (tempPerson != null) {
			System.out.print(tempPerson.getName() + " | ");
			tempPerson = tempPerson.getNext();
		}
		System.out.println();
	}// end method

	/*
	 * Method for displaying the gift list. Each time we traverse the gift, we print its name. 
	 * It will traverse all the way until to the last node. The while loop will stop if we meet a null
	 * node.
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

}// end class
