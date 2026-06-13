package demo_payment_w_strategy;
import send_noti.*;

public class Main {
	public static void main(String[] args) {
		Order order = new Order(50000);
		order.setPaymentStrategy(new PayPal());
		order.processPayment();
		
		// Test Email notification
		SendNotification emailNoti = new SendNotification("user@example.com");
		emailNoti.setSendNoti(new Email("user@example.com"));
		System.out.println(emailNoti.pushNotification());
		
		// Test SMS notification
		SendNotification smsNoti = new SendNotification("0123456789");
		smsNoti.setSendNoti(new SMS("0123456789"));
		System.out.println(smsNoti.pushNotification());
		
		// Test Push notification
		SendNotification pushNoti = new SendNotification("iOS");
		pushNoti.setSendNoti(new PushNotification("iOS", "app@account"));
		System.out.println(pushNoti.pushNotification());
	}
}
