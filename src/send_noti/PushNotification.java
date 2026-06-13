package send_noti;

public class PushNotification implements SendNotificationStrategy {
	private String device;
	private String appAccount;
	
	public PushNotification(String device, String appAccount) {
		this.device = device;
		this.appAccount = appAccount;
	}

	@Override
	public boolean checkNotificationChannel(String input) {
		if(input != null && (input.equals(this.device) || input.equals(this.appAccount))) return true;
		return false;
	}

}
