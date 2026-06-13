package send_noti;

public class Email implements SendNotificationStrategy {
	private String receivedEmail;
	
	public Email(String receivedEmail) {
		super();
		this.receivedEmail = receivedEmail;
	}

	@Override
	public boolean checkNotificationChannel(String input) {
		if(this.receivedEmail != null && this.receivedEmail.equals(input)) return true;
		return false;
	}
}
