package demo_mvc_strategy;

public class BinConvertStrategy implements ConvertStrategy {

	@Override
	public String convert(int num) {
		return Integer.toBinaryString(num);
	}

}
