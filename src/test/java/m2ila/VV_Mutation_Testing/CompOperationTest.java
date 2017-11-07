package m2ila.VV_Mutation_Testing;

import org.junit.Test;

import junit.framework.Assert;
import m2ila.VV_Mutation_Testing.CompOp.*;

public class CompOperationTest {

	@Test
	public void LowerTest1(){
		Lower l = new Lower(1.0, 3.0);
		Assert.assertTrue(l.operation());
	}
	
	@Test
	public void LowerTest2(){
		Lower l = new Lower(1.0, 1.0);
		Assert.assertFalse(l.operation());
	}
	
	@Test
	public void LowerOrEqualTest1(){
		LowerOrEqual le = new LowerOrEqual(1.0, 1.0);
		Assert.assertTrue(le.operation());
	}
	
	@Test
	public void LowerOrEqualTest2(){
		LowerOrEqual le = new LowerOrEqual(1.0, 0.0);
		Assert.assertFalse(le.operation());
	}
	
	@Test
	public void HigherTest1(){
		Higher h = new Higher(5.0, 3.0);
		Assert.assertTrue(h.operation());
	}
	
	@Test
	public void HigherTest2(){
		Higher h = new Higher(3.0, 3.0);
		Assert.assertFalse(h.operation());
	}
	
	@Test
	public void HigherOrEqualTest1(){
		HigherOrEqual he = new HigherOrEqual(1.0, 1.0);
		Assert.assertTrue(he.operation());
	}
	
	@Test
	public void HigherOrEqualTest2(){
		HigherOrEqual he = new HigherOrEqual(0.0, 1.0);
		Assert.assertFalse(he.operation());
	}
}
