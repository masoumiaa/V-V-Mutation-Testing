package m2ila.VV_Mutation_Testing.CompOp;

public interface Comparison {
	void setA(double a);
	void setB(double b);
	double getA();
	double getB();
	boolean operation();
	void print();
}
