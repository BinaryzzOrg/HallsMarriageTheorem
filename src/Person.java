
public class Person {

	// === FIELD VARIABLES === //
	private Gift prefGift;
	private String name;
	private Person next;

	// === CONSTRUCTOR === //
	public Person(String name) {
		this.prefGift = null;
		this.name = name;
	}// end constructor

	// === METHOD == //
	/*
	 *  inserts the given gift object in the preferred gifts of the person
  	 *  traversing through the list and inserting it in the end
	 */
	public void insertPrefGift(Gift gift) {
		if (this.prefGift == null) {
			this.prefGift = gift;
			return;
		}
		Gift tempGift = prefGift;
		while (tempGift.getNext() != null) {
			tempGift = tempGift.getNext();
		}
		tempGift.setNext(gift);
	}// end method

	// === GETTER SETTERS === //
	public Gift getPrefGift() {
		return prefGift;
	}

	public void setPrefGift(Gift gift) {
		this.prefGift = gift;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getNext() {
		return next;
	}

	public void setNext(Person next) {
		this.next = next;
	}
}// end class
