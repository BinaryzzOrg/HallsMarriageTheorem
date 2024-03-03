
public class Gift {
	// == FIELD VARIABLES == //
	private String giftName;
	private boolean isTaken;

	// == Constructor == //
	public Gift(String giftName) {
		this.giftName = giftName;
		this.isTaken = false;
	}// end constructor

	// == GETTER SETTERS == //
	public String getName() {
		return this.giftName;
	}// end method

	public boolean takenStatus() {
		return this.isTaken;
	}// end method

	public void takeGift() {
		this.isTaken = true;
	}// end method

	public void returnGift() {
		this.isTaken = false;
	}// end method

}// end class
