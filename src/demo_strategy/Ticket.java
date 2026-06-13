package demo_strategy;
public class Ticket {
	private IPromoteStrategy promoteStrategy;
	private double price;
	private String name;
	public IPromoteStrategy getPromotedStrategy() {
		return promoteStrategy;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IPromoteStrategy setPromoteStrategy(IPromoteStrategy value) {
		return promoteStrategy = value;
	}
	
	public double getPromotedPrice() {
		return promoteStrategy.doDiscountStrategy(price);
	}
    public Ticket(IPromoteStrategy promoteStrategy){
        promoteStrategy = this.promoteStrategy;
    }
}
