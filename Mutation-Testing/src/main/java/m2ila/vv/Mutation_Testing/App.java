package m2ila.vv.Mutation_Testing;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Loader;
import javassist.NotFoundException;
import javassist.Translator;


public class App 
{
	public static void main(String[] args )
    {
        try {
        	// WIP 
        	// Transformation
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
			}
        	
        }

        catch(Throwable exc) {
            System.out.println("Oh, no! Something went wrong.");
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }

    }
    
}
