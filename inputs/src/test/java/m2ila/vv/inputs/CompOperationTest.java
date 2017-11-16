package m2ila.vv.inputs;

import org.junit.Test;

import junit.framework.Assert;
import m2ila.vv.inputs.ComparisonOperations;

public class CompOperationTest {

	ComparisonOperations compOp = new ComparisonOperations();
	@Test
	public void LowerTest1(){
		Assert.assertTrue(compOp.Lower(1.0, 3.0));
	}
	
	@Test
	public void LowerTest2(){
		Assert.assertFalse(compOp.Lower(1.0, 1.0));
	}
	
	@Test
	public void LowerOrEqualTest1(){
		Assert.assertTrue(compOp.LowerOrEqual(1.0, 1.0));
	}
	
	@Test
	public void LowerOrEqualTest2(){
		Assert.assertFalse(compOp.LowerOrEqual(1.0, 0.0));
	}
	
	@Test
	public void HigherTest1(){
		Assert.assertTrue(compOp.Higher(5.0, 3.0));
	}
	
	@Test
	public void HigherTest2(){
		Assert.assertFalse(compOp.Higher(3.0, 3.0));
	}
	
	@Test
	public void HigherOrEqualTest1(){
		Assert.assertTrue(compOp.HigherOrEqual(5.0, 3.0));
	}
	
	@Test
	public void HigherOrEqualTest2(){
		Assert.assertFalse(compOp.HigherOrEqual(3.0, 5.0));
	}
}
