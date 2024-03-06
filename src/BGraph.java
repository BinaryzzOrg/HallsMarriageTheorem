public class BGraph {

	// == FIELD VARIABLES == //
	private Person[] persons;
	private Gift[] gifts;
	private int personCount = 0, giftCount = 0;

	// == CONSTRUCTOR == //
	public BGraph() {
		this.persons = new Person[1];
		this.gifts = new Gift[1];
	}// end constructor

	// == GETTER SETTERS == //
	public Person[] getPersons() {
		return this.persons;
	}// end method

	public Gift[] getGifts() {
		return this.gifts;
	}// end method

	// == BIPARTITE OPERATIONS == //

	/*
	 * 
	 */
	public void addPerson(Person person) {
		if (personCount != 10) {
			ensurePersonsSize();
			persons[personCount++] = person;
		} else {
			System.out.println("There are already 10 Persons in the graph.");
			return;
		} // end if else
	}// end method

	/*
	 * 
	 */
	public void addGift(Gift gift) {
		if (giftCount != 10) {
			ensureGiftsSize();
			gifts[giftCount++] = gift;
		} else {
			System.out.println("Gift count is already 10.");
			return;
		} // end if else
	}// end method

	/*
	 * 
	 */
	private void ensurePersonsSize() {
		if (personCount == persons.length) {
			Person[] temp = new Person[personCount + 3];
			for (int index = 0; index < personCount; index++) {
				temp[index] = persons[index];
			} // end for
			persons = temp;

		} // end if
	}// end method

	/*
	 * 
	 */
	private void ensureGiftsSize() {
		if (giftCount == gifts.length) {
			Gift[] temp = new Gift[giftCount + 3];

			for (int index = 0; index < giftCount; index++) {
				temp[index] = gifts[index];
			} // end for

			gifts = temp;
		} // end if
	}// end method

	/*
	 * 
	 */
	public void addEdge(Person person, Gift gift) {
		Person chosenPerson = findPerson(person);
		Gift chosenGift = findGift(gift);

		if (chosenPerson != null && chosenGift != null) {
			chosenPerson.addPreferredGift(chosenGift);
		} else {
			return;

		} // end if else
	}// end method

	/*
	 * 
	 */
	public Person findPerson(Person person) {
		for (Person element : persons) {
			if (element.equals(person)) {
				return element;

			} // end if
		} // end for
		return null;

	}// end method

	/*
	 * 
	 */
	public Gift findGift(Gift gift) {
		for (Gift element : gifts) {
			if (element.equals(gift)) {
				return element;

			} // end if
		} // end for
		return null;

	}// end method

	/*
	 * 
	 */
	public void match() {

	}// end method

	// == for debug codes == //
	public void printPersonArray() {
		for (int i = 0; i < persons.length; i++) {
			Person output = persons[i];
			System.out.println(output.getName());
		} // end for
	}// end method

	public void printGiftsArray() {
		for (int i = 0; i < gifts.length; i++) {
			Gift output = gifts[i];
			System.out.println(output.getName());
		} // end for
	}// end method

	// == end of debug == //

}// end class