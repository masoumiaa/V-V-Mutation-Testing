package m2ila.vv.project.inputs;


import org.junit.Test;

import junit.framework.Assert;
import m2ila.vv.inputs.BinOperations;

public class BinOperationTest {

	BinOperations binop = new BinOperations(); 
	
	@Test
	public void AdditionTest1(){
		Assert.assertEquals(binop.Addition(1.0,1.0),2.0);
	}
	
	@Test
	public void SubstractionTest1(){
		Assert.assertEquals(binop.Substraction(1.0,1.0),0.0);
	}
	
	@Test
	public void MultiplicationTest1(){
		Assert.assertEquals(binop.Multiplication(2.0,2.0),4.0);
	}
	
	@Test
	public void DivisionTest1() throws Exception{
		Assert.assertEquals(binop.Division(2.0,2.0),1.0);
	}
}
