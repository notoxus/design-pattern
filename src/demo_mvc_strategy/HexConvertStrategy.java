package demo_mvc_strategy;

public class HexConvertStrategy implements ConvertStrategy {

	@Override
	public String convert(int num) {
		return Integer.toHexString(num);
	}

}
