
public class Person {

	// == FIELD VARIABLES == //
	private String name;
	private Gift[] preferredGifts;
	private int giftCount = 0;

	// == CONSTRUCTOR == //
	public Person(String name) {
		this.name = name;
		this.preferredGifts = new Gift[1];
	}// end constructor

	// == GETTER SETTERS == //
	public String getName() {
		return this.name;
	}// end method

	public Gift[] getPreferredGifts() {
		return this.preferredGifts;
	}// end method

	public Gift getGift(int index) {
		return preferredGifts[index];
	}// end method

	// == PERSON METHODS == //
	/*
	 * 
	 */
	public void addPreferredGift(Gift gift) {
		// avoid duplicates
		for (Gift listedGift : preferredGifts) {
			if (gift.equals(listedGift)) {
				System.out.println(name + " already prefer this gift: " + gift.getName());
				return;
			} // end if
		} // end for

		if (giftCount != 10) {
			ensureGiftsSize();
			this.preferredGifts[giftCount++] = gift;
		} // end if
	}// end method

	/*
	 * 
	 */
	private void ensureGiftsSize() {
		if (giftCount == preferredGifts.length) {
			Gift[] temp = new Gift[giftCount + 3];

			for (int index = 0; index < giftCount; index++) {
				temp[index] = preferredGifts[index];
			} // end for

			preferredGifts = temp;
		} // end if
	}// end method

}// end class
