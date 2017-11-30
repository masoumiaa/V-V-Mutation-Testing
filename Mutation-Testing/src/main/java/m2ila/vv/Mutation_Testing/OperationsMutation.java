package m2ila.vv.Mutation_Testing;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;

public class OperationsMutation {
	
	ClassLoader cl = new ClassLoader();
	TestRunner tr = new TestRunner();
	List<Integer> places;
	CtClass ctClass;
	StringBuilder sb = new StringBuilder();
	InstructionReplacementMutator irm;
	
	public void runBinOpMutations() throws NotFoundException, ClassNotFoundException, MalformedURLException, BadBytecode{
		//Load Classes
		ClassPool pool = cl.loadClasses();
		
		//get Binary operations class
		ctClass = cl.getCtClass(pool,"BinOperations");
		
		// Addition mutation
		this.runMutation("Addition", Remplacement.PLUS_MINUS);
		// Subtraction Mutation
		this.runMutation("Subtraction", Remplacement.MINUS_PLUS);
		// Division Mutation
		this.runMutation("Division", Remplacement.DIV_MULT);
		// Multiplication Mutation
		this.runMutation("Multiplication", Remplacement.MULT_DIV);
	}
	
	public void runCompOpMutations() throws NotFoundException, ClassNotFoundException, MalformedURLException, BadBytecode{
		//Load Classes
		ClassPool pool = cl.loadClasses();
		
		//get Binary operations class
		ctClass = cl.getCtClass(pool,"ComparisonOperations");
		
		// Lower mutation
		this.runMutation("Lower", Remplacement.LOWER_LOWEROREQUAL);
		// LowerOrEqual Mutation
		this.runMutation("LowerOrEqual", Remplacement.LOWEROREQUAL_LOWER);
		// Higher Mutation
		this.runMutation("Higher", Remplacement.GREATER_GREATEROREQUAL);
		// HigherOrEqual Mutation
		this.runMutation("HigherOrEqual", Remplacement.GREATEROREQUAL_GREATER);
	}
	
	private void runMutation(String operation, Remplacement tuple) throws NotFoundException, BadBytecode, ClassNotFoundException, MalformedURLException{
		//get method by name
		CtMethod ctMethod = cl.getMethodByName(this.ctClass, operation);
		
		// Init Instruction Mutator
		irm = new InstructionReplacementMutator(tuple);
		
		// Get operator places
		places = new ArrayList<Integer>();
		places = irm.getPlaces(ctMethod);
		
		// For each index, Run operator mutation, run tests
		for (Integer index : places) {
			// mutation
			irm.substitue(ctMethod, index);
			// write copy class
			// TODO ctClass.writeFile(); or ctClass.write(new DataOutputStream(new FileOutputStream("tempClasses/B**.class")));
			// Run Tests 
			String testReport = tr.runTests("BinOperationTest");
			this.sb.append(testReport+'\n');
		}
	}
}
