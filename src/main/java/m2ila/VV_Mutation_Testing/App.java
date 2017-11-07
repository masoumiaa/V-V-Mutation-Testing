package m2ila.VV_Mutation_Testing;

import m2ila.VV_Mutation_Testing.BinOp.Addition;
import m2ila.VV_Mutation_Testing.BinOp.Division;
import m2ila.VV_Mutation_Testing.BinOp.Multiplication;
import m2ila.VV_Mutation_Testing.BinOp.Substraction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
    }
}
