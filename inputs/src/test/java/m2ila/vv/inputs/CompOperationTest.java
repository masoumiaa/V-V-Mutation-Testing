package m2ila.vv.inputs;

import static org.junit.Assert.*;
import org.junit.Test;
import m2ila.vv.inputs.ComparisonOperations;

public class CompOperationTest {

	ComparisonOperations compOp = new ComparisonOperations();
	@Test
	public void LowerTest1(){
		assertTrue(compOp.Lower(1.0, 3.0));
	}
	
	@Test
	public void LowerTest2(){
		assertFalse(compOp.Lower(1.0, 1.0));
	}
	
	@Test
	public void LowerOrEqualTest1(){
		assertTrue(compOp.LowerOrEqual(1.0, 1.0));
	}
	
	@Test
	public void LowerOrEqualTest2(){
		assertFalse(compOp.LowerOrEqual(1.0, 0.0));
	}
	
	@Test
	public void HigherTest1(){
		assertTrue(compOp.Higher(5.0, 3.0));
	}
	
	@Test
	public void HigherTest2(){
		assertFalse(compOp.Higher(3.0, 3.0));
	}
	
	@Test
	public void HigherOrEqualTest1(){
		assertTrue(compOp.HigherOrEqual(5.0, 3.0));
	}
	
	@Test
	public void HigherOrEqualTest2(){
		assertFalse(compOp.HigherOrEqual(3.0, 5.0));
	}
}
