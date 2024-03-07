
public class Person {

	// === FIELD VARIABLES === //
	private Gift prefGift;
	private boolean isAssigned;
	private String name;
	private Person next;

	// === CONSTRUCTOR === //
	public Person(String name) {
		this.prefGift = null;
		this.isAssigned = false;
		this.name = name;
	}// end constructor

	// === METHOD == //
	/*
	 * 
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

	public boolean isAssigned() {
		return isAssigned;
	}

	public void setAssigned(boolean isAssigned) {
		this.isAssigned = isAssigned;
	}

	public Person getNext() {
		return next;
	}

	public void setNext(Person next) {
		this.next = next;
	}
}// end class
