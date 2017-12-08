package m2ila.vv.Mutation_Testing;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class MethodBodyMutator {

	private CtClass ctClass;
	private CtMethod ctMethod;
	private ClassLoader clo;
	private TestRunner tr;
	
	public MethodBodyMutator(String classesUrl, String testsUrl){
		this.tr = new TestRunner(classesUrl, testsUrl);
	}
	
	public void removeBodyMutation() throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException{
		// Load class 
		this.loadClass();
		// Load method
		this.ctMethod = clo.getMethodByName(this.ctClass, "method1");
		// Remove method body
		this.removeMethodBody();
		// Run Tests 
		this.tr.runTests(ctClass.getSimpleName());
	}
	
	public void replaceBodyToFalseMutation() throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException{
		// Load class 
		this.loadClass();
		// Load method
		this.ctMethod = clo.getMethodByName(this.ctClass, "method2");
		// Replace method body by (return false)
		this.replaceMethodBodyToFalse();
		// Run Tests 
		this.tr.runTests(ctClass.getSimpleName());
	}

	private void loadClass() throws NotFoundException, CannotCompileException{
		// Load classes
		this.clo = new ClassLoader();
		ClassPool pool = clo.loadClasses();
		// Get method class
		this.ctClass = clo.getCtClass(pool, "MethodOperations");
	}
	
	private void replaceMethodBodyToFalse() throws CannotCompileException, IOException {
		//Replace method body by (return false) 
		this.ctMethod.setBody("return false;");	
		
		// write copy class
		ctClass.writeFile("output");
		// now modifiable again
		ctClass.defrost();
		
		// TODO replace prints with reporting
		System.out.println("Method Body Replaced by (return false;)");
	}
	
	private void removeMethodBody() throws NotFoundException, CannotCompileException, IOException{
		//Remove method body 
		this.ctMethod.setBody("return;");		

		// write copy class
		ctClass.writeFile("output");
		// now modifiable again
		ctClass.defrost();
		
		// TODO replace prints with reporting
		System.out.println("Method Body Removed");
	}
}