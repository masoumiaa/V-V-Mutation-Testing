package m2ila.VV_Mutation_Testing;

import org.junit.Test;

import junit.framework.Assert;
import m2ila.VV_Mutation_Testing.BinOp.*;

public class BinOperationTest {

	@Test
	public void AdditionTest1(){
		Addition add = new Addition(1, 1);
		Assert.assertEquals(add.operation(),2);
	}
	
	@Test
	public void SubstractionTest1(){
		Substraction sub = new Substraction(4, 2);
		Assert.assertEquals(sub.operation(),2);
	}
	
	@Test
	public void MultiplicationTest1(){
		Multiplication mult = new Multiplication(2, 2);
		Assert.assertEquals(mult.operation(),4);
	}
	
	@Test
	public void DivisionTest1(){
		Division div = new Division(4, 2);
		Assert.assertEquals(div.operation(),2);
	}
}
