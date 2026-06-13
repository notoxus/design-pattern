package demo_payment_w_strategy;

public interface IPayment {
	public void auth();
	public void connectToServer();
	public double transactionProcess(double amount);
}
