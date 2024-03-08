
public class Gift {

	// === FIELD VARIABLES === //
	private String name;
	private Gift next;

	// === CONSTRUCTOR === //
	public Gift(String name) {
		this.name = name;
		this.isAssigned = false;
	}// end constructor

	// === GETTER SETTERS === //
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gift getNext() {
		return next;
	}

	public void setNext(Gift next) {
		this.next = next;
	}
}// end method
