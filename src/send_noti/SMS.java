package send_noti;

public class SMS implements SendNotificationStrategy {
	private String phoneNum;
	
	public SMS(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public boolean checkNotificationChannel(String input) {
		if(this.phoneNum != null && this.phoneNum.equals(input)) return true;
		return false;
	}

}
