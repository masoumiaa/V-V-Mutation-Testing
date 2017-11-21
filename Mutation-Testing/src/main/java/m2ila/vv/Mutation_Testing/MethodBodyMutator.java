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
		// Load classes
		ClassLoader clo = new ClassLoader();
		ClassPool pool = clo.loadClasses();
		// Get method class
		this.ctClass = clo.getCtClass(pool, "MethodOperations");
		// Load method
		this.ctMethod = clo.getMethodByName(this.ctClass, "method");
		// Remove method body
		this.removeMethodBody();
		// TODO this.runTests()
	}
	
	private void removeMethodBody() throws NotFoundException, CannotCompileException{
		//Remove method body 
		this.ctMethod.setBody("");		 
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