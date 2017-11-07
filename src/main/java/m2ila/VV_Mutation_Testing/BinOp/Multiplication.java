package m2ila.VV_Mutation_Testing.BinOp;

public class Multiplication implements BinOperation{

	private double a;
	private double b;
	
	public Multiplication(double a, double b){
		this.a = a;
		this.b = b;
	}
	
	public void setA(double a) {
		this.a = a;
		
	}

	public void setB(double b) {
		this.b = b;
		
	}

	public double getA() {
		return this.a;
	}

	public double getB() {
		return this.b;
	}

	public double operation() {
		return this.a * this.b;
	}

	public void print() {
		System.out.println( this.a+" * "+this.b+" = "+operation());
	}
}
