package m2ila.vv.Mutation_Testing;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Loader;
import javassist.NotFoundException;
import javassist.Translator;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.expr.ExprEditor;
import javassist.expr.FieldAccess;
import javassist.expr.MethodCall;
import javassist.expr.NewExpr;


public class App 
{
	public void substitue(CtMethod ctMethod) throws BadBytecode{
		// dadd (+) opcode
		int PLUS_CODE=99;
		// dsub (-) opcode
		int MINUS_CODE=103;
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
	        //Checking if Opcode is +
	        if(_valueOfIndex8Bit==PLUS_CODE ) {
	            //Changing instruction from + to -
	            _codeIterator.writeByte(MINUS_CODE, _indexOfCode);
	        }
	    }
	}
	public static void main(String[] args )
	{
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
						
						//Work in Progres ..
						
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
