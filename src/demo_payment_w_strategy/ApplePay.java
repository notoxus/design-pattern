package demo_payment_w_strategy;

public class ApplePay implements IPayment {

	@Override
	public void auth() {
		System.out.println("Xac thuc voi Apple Pay");
		
	}

	@Override
	public void connectToServer() {
		System.out.println("Ket noi voi cong thanh toan Apple Pay");
	}

	@Override
	public double transactionProcess(double amount) {
		System.out.println("Dang xu ly giao dich voi " + getClass().getSimpleName());
		return amount;
	}
}
