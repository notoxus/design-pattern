
public class QuaterDiscountStrategy implements IPromoteStrategy {

	@Override
	public double doDiscountStrategy(double price) {
		// TODO Auto-generated method stub
		return price*0.75;
	}

}
