package demo_payment_w_strategy;

public class Order {
	private double amount;
	private IPayment paymentStrategy;
	public Order(double amount) {
		this.amount = amount;
	}
	
	public void setPaymentStrategy(IPayment paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
	
	public double processPayment() {
        if (this.paymentStrategy == null) {
            System.out.println("Lỗi: Bạn chưa chọn phương thức thanh toán!");
            return 0.0; 
        }

        System.out.println("--- Bat dau thanh toan don hang voi so tien: " + amount + "VND ---");
        
        this.paymentStrategy.auth();
        this.paymentStrategy.connectToServer();
		double result = this.paymentStrategy.transactionProcess(amount);
        
        System.out.println("Thanh toan thanh cong!\n");
        return result;
	}
}
