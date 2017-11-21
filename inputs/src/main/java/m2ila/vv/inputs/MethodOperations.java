package m2ila.vv.inputs;

public class MethodOperations {
	
	private double a = 0;
	
	public void method1(){
		this.a = 1;
	}
	
	public boolean method2(double b){
		return ( this.a == b );
	}

	public double getA() {
		return this.a;
	}
	
	public void setA(double a){
		this.a = a;
	}
}
