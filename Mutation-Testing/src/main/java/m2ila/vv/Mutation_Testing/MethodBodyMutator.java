package m2ila.vv.Mutation_Testing;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class MethodBodyMutator {

	private CtClass ctClass;
	private CtMethod ctMethod;
	
	public void runMutation() throws NotFoundException, CannotCompileException{
		this.loadClass();
		this.loadMethod();
		this.removeMethodBody();
		// TODO this.runTests()
	}
	
	private void loadClass() throws NotFoundException{
		// Creating container
		ClassPool pool = ClassPool.getDefault();
		// load classes folder
		pool.appendClassPath("/home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes");
		//creating compile-time class
		ctClass = pool.get("m2ila.vv.inputs.MethodOperations");
	}
	
	private void loadMethod() throws NotFoundException{
		//get method by name
		ctMethod = ctClass.getDeclaredMethod("method");
		//printing method name 
		// TODO replace prints with reporting
		System.out.println("Method found : "+ctMethod.getName());
	}
	
	private void removeMethodBody() throws NotFoundException, CannotCompileException{
		//Remove method body 
		ctMethod.setBody("");		 
		// TODO replace prints with reporting
		System.out.println("Method Body Removed");
		
		//Getting all methodes 
		/*////////////// TODO move this code
		 * final CtMethod[] existingMethods = ctClass.getDeclaredMethods();
		for (CtMethod ctMethod : existingMethods) {
		
			// Substituting method body 
			ctMethod.instrument(new ExprEditor() {
				public void edit(NewExpr expr) throws CannotCompileException{
					if (expr.getClass().equals("+"))
						System.out.println("Found +");
				}
			});
		}*/
	}
}