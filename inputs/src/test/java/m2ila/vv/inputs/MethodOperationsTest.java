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
	public void methodTest1(){
		mo.method();
		Assert.assertEquals(mo.getA(),1.0, 0.0);
	}
	
}
