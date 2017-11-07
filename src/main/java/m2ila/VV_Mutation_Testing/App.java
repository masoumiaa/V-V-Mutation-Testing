package m2ila.VV_Mutation_Testing;

import m2ila.VV_Mutation_Testing.BinOp.*;
import m2ila.VV_Mutation_Testing.CompOp.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// Binary operations
        Addition add = new Addition(1.0, 1.0);
        add.operation();
        add.print();
        
        Substraction sub = new Substraction(2.0, 1.0);
        sub.operation();
        sub.print();
        
        Multiplication mult = new Multiplication(2.0, 2.0);
        mult.operation();
        mult.print();
        
        Division div = new Division(4.0, 2.0);
        div.operation();
        div.print();
        
        System.out.println("*****************************************");
        //Comparison operations
        Lower l = new Lower(1.0, 2.0);
        l.operation();
        l.print();
        
        LowerOrEqual le = new LowerOrEqual(1.0, 1.0);
        le.operation();
        le.print();
        
        Higher h = new Higher(3.0, 2.0);
        h.operation();
        h.print();
        
        HigherOrEqual he = new HigherOrEqual(2.0, 2.0);
        he.operation();
        he.print();
        
        
        
        
        
    }
}
