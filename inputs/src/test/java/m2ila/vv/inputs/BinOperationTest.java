package m2ila.vv.inputs;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BinOperationTest {
	
	private BinOperations binop;
	
	@Before
	public void setUp(){
		binop = new BinOperations(); 
	}

	@Test
	public void AdditionTest1(){
		Assert.assertEquals(binop.Addition(1.0,1.0),2.0, 0.0);
	}
	
	@Test
	public void SubtractionTest1(){
		Assert.assertEquals(binop.Subtraction(1.0,1.0),0.0, 0.0);
	}
	
	@Test
	public void MultiplicationTest1(){
		Assert.assertEquals(binop.Multiplication(2.0,2.0),4.0,0.0);
	}
	
	@Test
	public void DivisionTest1() throws Exception{
		Assert.assertEquals(binop.Division(2.0,2.0),1.0, 0.0);
	}
	
	@Test(expected = Exception.class)
	public void DivisionTest2() throws Exception{
		binop.Division(2.0,0.0);
	}
}
