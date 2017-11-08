package m2ila.vv.Mutation_Testing;

import javassist.CannotCompileException;
import javassist.ClassPool;
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
        	ClassPool pool = ClassPool.getDefault();
        	Loader loader = new Loader(pool);
        	
        	Translator logger = new Translator() {

				public void onLoad(ClassPool pool, String classname) throws NotFoundException, CannotCompileException {
					System.out.println(classname);
					// Transformation :modifier la classe 
				}

				public void start(ClassPool arg0) throws NotFoundException, CannotCompileException {
					System.out.println("Starting...");
					
				}
        	};
        	
        	loader.addTranslator(pool, logger);
        	pool.appendClassPath("/home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/classes");
        	// TODO delete this line 
        	loader.run("m2ila.vv.inputs.App", args);
        	
			
           // throw new Throwable();
        }

        catch(Throwable exc) {
            System.out.println("Oh, no! Something went wrong.");
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }

    }
    
}
