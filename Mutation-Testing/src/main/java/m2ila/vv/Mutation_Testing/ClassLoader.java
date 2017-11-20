package m2ila.vv.Mutation_Testing;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.NewExpr;

public class ClassLoader {

	public ClassPool loadClasses() throws NotFoundException{
		// Creating container
		ClassPool pool = ClassPool.getDefault();
		pool.appendClassPath("/home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes");
		return pool;
	}
	
	public CtClass getCtClass(ClassPool pool,String className) throws NotFoundException{
		//creating compile-time class
		CtClass ctClass = pool.get("m2ila.vv.inputs."+className);		
		return ctClass;
	}
	
	public CtMethod getMethodByName(CtClass ctClass, String name) throws NotFoundException {
		CtMethod ctm = ctClass.getDeclaredMethod(name);
		return ctm;
	}
	//TODO move this function to returnMutator
	public static void mutate(){
		try {
			// WIP 
			// Creating container
			ClassPool pool = ClassPool.getDefault();
			pool.appendClassPath("/home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes");

			//creating compile-time class
			CtClass ctClass = pool.get("m2ila.vv.inputs.BinOperations");

			//Getting all methodes 
			final CtMethod[] existingMethods = ctClass.getDeclaredMethods();

			for (CtMethod ctMethod : existingMethods) {
				//printing methodes names 
				// TODO replace prints with reporting
				System.out.println(ctMethod.getName());

				// Substituting operators 
				ctMethod.instrument(new ExprEditor() {
					public void edit(NewExpr expr) throws CannotCompileException{
						// TODO call substitute method 
						//substitute(ctMethod);
						
						//Work in Progress ..
						
						if (expr.getClass().equals("+"))
							System.out.println("Found +");
					}
				});
			}

		}

		catch(Throwable exc) {
			System.out.println("Oh, no! Something went wrong.");
			System.out.println(exc.getMessage());
			exc.printStackTrace();
		}

	}
}
