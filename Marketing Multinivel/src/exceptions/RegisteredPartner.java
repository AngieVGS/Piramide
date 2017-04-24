package exceptions;

public class RegisteredPartner extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RegisteredPartner() {
		super("Partner is already registered");
	}
}