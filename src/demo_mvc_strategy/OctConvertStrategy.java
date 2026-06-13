package demo_mvc_strategy;

public class OctConvertStrategy implements ConvertStrategy{

	@Override
	public String convert(int num) {
		return Integer.toOctalString(num);
	}

}
