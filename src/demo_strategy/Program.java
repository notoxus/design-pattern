package demo_strategy;
import java.util.Random;

public class Program {
	public static void main(String[] args) {
		System.out.println("Start getting tickets!");
		Random random = new Random();
		for (int i = 0; i < 5; i++) {
			Ticket ticket = new Ticket(null);
			ticket.setName("Ticket " + i);
			ticket.setPrice(50d * i);
			
			generatePromotedStrategy(random, ticket);
			logTicketDetail(ticket);
			
			generatePromotedStrategy(random, ticket);
			logTicketDetail(ticket);
		}
			
	}
	private static void generatePromotedStrategy(Random random, Ticket ticket) {
		int strategyIndex = random.nextInt(0, 3);
		switch (strategyIndex) {
		case 0:
			ticket.setPromoteStrategy(new NoDiscountStrategy());
			break;
		case 1:
			ticket.setPromoteStrategy(new QuaterDiscountStrategy());
			break;
		case 2:
			ticket.setPromoteStrategy(new FourFiftyDiscountStrategy());
			break;
		default:
			ticket.setPromoteStrategy(new HalfDiscountStrategy());
			break;
		}
	}
	private static void logTicketDetail(Ticket ticket) {
		System.out.println("Promoted price of " + ticket.getName() +" is "
		+ ticket.getPromotedStrategy().getClass().getSimpleName() 
		+ " is " + ticket.getPromotedPrice());
	}
}
