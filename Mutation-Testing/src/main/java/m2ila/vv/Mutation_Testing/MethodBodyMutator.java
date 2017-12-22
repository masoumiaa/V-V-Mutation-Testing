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
	private StringBuilder sb = new StringBuilder();
	private String classesUrl;
	private String testsUrl;
	
	public MethodBodyMutator(String classesUrl, String testsUrl){
		this.classesUrl = classesUrl;
		this.classesUrl = testsUrl;
		this.tr = new TestRunner(classesUrl, testsUrl);
	}
	
	public void removeBodyMutation() throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException{
		// Load class 
		this.loadClass();
		// Load method
		this.ctMethod = clo.getMethodByName(this.ctClass, "method1");
		sb.append("<h3>- Method : method1</h3>\n");
		// Remove method body
		this.removeMethodBody();
		// Run Tests 
		String testReport = this.tr.runTests(ctClass.getSimpleName());
		sb.append(testReport);
	}
	
	public void replaceBodyToFalseMutation() throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException{
		// Load class 
		this.loadClass();
		// Load method
		this.ctMethod = clo.getMethodByName(this.ctClass, "method2");
		sb.append("<h3>- Method : method2</h3>\n");
		// Replace method body by (return false)
		this.replaceMethodBodyToFalse();
		// Run Tests 
		String testReport = this.tr.runTests(ctClass.getSimpleName());
		sb.append(testReport);
	}

	private void loadClass() throws NotFoundException, CannotCompileException{
		// Load classes
		this.clo = new ClassLoader(this.classesUrl);
		ClassPool pool = clo.loadClasses();
		// Get method class
		this.ctClass = clo.getCtClass(pool, "MethodOperations");
		sb.append("<h2>* Class : MethodOperations</h2>\n");
	}
	
	private void replaceMethodBodyToFalse() throws CannotCompileException, IOException {
		//Replace method body by (return false) 
		this.ctMethod.setBody("return false;");	
		
		// write copy class
		ctClass.writeFile("output");
		// now modifiable again
		ctClass.defrost();
		
		// reporting
		sb.append("Method Body Replaced by (return false;)<br>\n");
	}
	
	private void removeMethodBody() throws NotFoundException, CannotCompileException, IOException{
		//Remove method body 
		this.ctMethod.setBody("return;");		

		// write copy class
		ctClass.writeFile("output");
		// now modifiable again
		ctClass.defrost();
		
		// reporting
		sb.append("Method Body Removed<br>\n");
	}
	
	public StringBuilder getSb() {
		return sb;
	}
}