package demo_mvc_strategy;

public class ControllerNumber {
	private ModelNumber model;
	private ConvertStrategy strategy;

	public ControllerNumber(ModelNumber model) {
		this.model = model;
	}

	public void setStrategy(ConvertStrategy strategy) {
		this.strategy = strategy;
	}

	public String convert(String input) {
		try {
			int number = Integer.parseInt(input);
			model.setNumber(number);
			
			if (strategy == null) {
				return "You need to choose base num";
			}
			return strategy.convert(model.getNumber());
			
		} catch (NumberFormatException e) {
			return "You don't number to convert!";
		}
	}
}