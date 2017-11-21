package m2ila.vv.inputs;

public class BinOperations {

	public double Addition(double a, double b){
		return a + b;
	}
	
	public double Subtraction(double a, double b){
		return a - b;
	}
	
	public double Multiplication(double a, double b){
		return a * b;
	}
	
	public double Division(double a, double b) throws Exception{
		if (b == 0){
			throw new Exception("Divider can't be zero");
		}
		return a / b;
	}
	
}
