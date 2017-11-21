package m2ila.vv.inputs;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MethodOperationsTest {
	
	private MethodOperations mo;
	
	@Before
	public void setUp(){
		mo = new MethodOperations(); 
	}

	@Test
	public void method1Test1(){
		mo.method1();
		Assert.assertEquals(mo.getA(),1.0, 0.0);
	}
	
	@Test
	public void method2Test1(){
		Assert.assertTrue(mo.method2(0.0));
	}
	
	@Test
	public void method2Test2(){
		mo.setA(2.0);
		Assert.assertTrue(mo.method2(2.0));
	}
	
}
