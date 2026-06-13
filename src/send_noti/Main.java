package send_noti;

public class Main {
	public static void main(String[] args) {
		SendNotification sendNoti = new SendNotification("Email");
		System.out.println(sendNoti.pushNotification());
	}
}
