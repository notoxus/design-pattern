package send_noti;

public class SendNotification {
	private SendNotificationStrategy sendNoti;
	private String input;
	public SendNotification(String input) {
		this.input = input;
	}

	public void setSendNoti(SendNotificationStrategy sendNoti) {
		if(sendNoti != null && sendNoti.checkNotificationChannel(this.input) == true) {
			this.sendNoti = sendNoti;
		}
	}

	public String pushNotification() {
		if(this.sendNoti != null && this.sendNoti.checkNotificationChannel(this.input) == true) {
			return sendNoti.getClass().getSimpleName();
		}
		return null;
	}
}
