package m2ila.vv.Mutation_Testing;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;

public class OperationsMutation {
	
	ClassLoader cl;
	TestRunner tr;
	List<Integer> places;
	CtClass ctClass;
	StringBuilder sb;
	InstructionReplacementMutator irm;
	
	public OperationsMutation(String classesUrl, String testsUrl){
		this.tr = new TestRunner(classesUrl, testsUrl);
		this.cl = new ClassLoader(classesUrl);
	}
	
	public void runBinOpMutations() throws NotFoundException, ClassNotFoundException, BadBytecode, CannotCompileException, IOException{	
		
		// Load Classes	
		ClassPool pool = cl.loadClasses();	
		
		// init report 
		sb = new StringBuilder();
		
		// get Binary operations class
		ctClass = cl.getCtClass(pool,"BinOperations");
		sb.append("<h2>* Class : BinOperations</h2>\n");
		
		// Addition mutation
		this.runMutation("Addition", Remplacement.PLUS_MINUS);
		// Subtraction Mutation
		this.runMutation("Subtraction", Remplacement.MINUS_PLUS);
		// Division Mutation
		this.runMutation("Division", Remplacement.DIV_MULT);
		// Multiplication Mutation
		this.runMutation("Multiplication", Remplacement.MULT_DIV);
	}
	
	public void runCompOpMutations() throws NotFoundException, ClassNotFoundException, BadBytecode, CannotCompileException, IOException{
		//Load Classes
		ClassPool pool = cl.loadClasses();
		
		// init report 
		sb = new StringBuilder();
				
		//get Binary operations class
		ctClass = cl.getCtClass(pool,"ComparisonOperations");
		sb.append("<h2>* Class : ComparisonOperations</h2>\n");
		
		// Lower mutation
		this.runMutation("Lower", Remplacement.LOWER_LOWEROREQUAL);
		// LowerOrEqual Mutation
		this.runMutation("LowerOrEqual", Remplacement.LOWEROREQUAL_LOWER);
		// Higher Mutation
		this.runMutation("Higher", Remplacement.GREATER_GREATEROREQUAL);
		// HigherOrEqual Mutation
		this.runMutation("HigherOrEqual", Remplacement.GREATEROREQUAL_GREATER);
	}
	
	private void runMutation(String operation, Remplacement tuple) throws NotFoundException, BadBytecode, ClassNotFoundException, CannotCompileException, IOException{

		//get method by name
		CtMethod ctMethod = this.cl.getMethodByName(ctClass, operation);
		sb.append("<h3>- Method : "+ctMethod.getName()+"</h3>\n");
		
		// Init Instruction Mutator
		irm = new InstructionReplacementMutator(tuple);
		
		// Get operator places
		places = new ArrayList<Integer>();
		places = irm.getPlaces(ctMethod);
		
		// For each index, Run operator mutation, run tests
		for (Integer index : places) {
			sb.append("<h4>Operator found at index :"+index+"</h4>\n");
			// launch mutation
			irm.substitue(ctMethod, index, false);
			sb.append("Substitute done !<br>\n");
			
			// write copy class
			ctClass.writeFile("output");
			// now modifiable again
			ctClass.defrost();
			
			// Run Tests 
			String testReport = tr.runTests(ctClass.getSimpleName());
			sb.append(testReport);
			
			// revert last mutation
			irm.substitue(ctMethod, index, true);
		}
	}
	
	public StringBuilder getSb() {
		return sb;
	}
}
