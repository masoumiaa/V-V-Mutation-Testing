package m2ila.vv.Mutation_Testing;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class MethodBodyMutator {

	public static void RemoveBody() throws NotFoundException, CannotCompileException{
		// WIP 
		// Creating container
		ClassPool pool = ClassPool.getDefault();
		pool.appendClassPath("/home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes");

		//creating compile-time class
		CtClass ctClass = pool.get("m2ila.vv.inputs.MethodOperations");
		//get method by name
		CtMethod ctMethod = ctClass.getDeclaredMethod("method");
		
		//printing method name 
		// TODO replace prints with reporting
		System.out.println("Method found : "+ctMethod.getName());

		//Remove method body 
		ctMethod.setBody("");
		 
		// TODO replace prints with reporting
		System.out.println("Method Body Removed");
		
		//Getting all methodes 
		/* TODO move this code
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