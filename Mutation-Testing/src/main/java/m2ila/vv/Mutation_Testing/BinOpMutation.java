package m2ila.vv.Mutation_Testing;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;

public class BinOpMutation {

	ClassLoader cl = new ClassLoader();
	TestRunner tr = new TestRunner();
	List<Integer> places;
	CtClass ctClass;
	
	public void runBinOpMutations() throws NotFoundException, ClassNotFoundException, MalformedURLException, BadBytecode{
		//Load Classes
		ClassPool pool = cl.loadClasses();
		//get Binary operations class
		ctClass = cl.getCtClass(pool,"BinOperations");
		// Addition mutation
		this.runAdditionMutation();
		// Subtraction Mutation
		this.runSubtractionMutation();
		// Division Mutation
		this.runDivisionMutation();
		// Multiplication Mutation
		this.runMultiplicationMutation();
	}
	
	/////////////////////--- Addition ---////////////////////
	private void runAdditionMutation() throws NotFoundException, BadBytecode, ClassNotFoundException, MalformedURLException{
		//get addition method 
		CtMethod addCtMethod = cl.getMethodByName(this.ctClass, "Addition");
		// Addition mutator
		AdditionMutator am = new AdditionMutator();
		// Get operator '+' places
		places = new ArrayList<Integer>();
		places = am.getPlaces(addCtMethod);
		// For each index, Run '+' mutation
		for (Integer index : places) {
			am.substitue(addCtMethod, index);
		}
		// Run Tests 
		tr.runTests();
	}
	
	/////////////////////--- Subtraction ---////////////////////
	private void runSubtractionMutation() throws NotFoundException, BadBytecode, ClassNotFoundException, MalformedURLException{
		//get Subtraction method 
		CtMethod subCtMethod = cl.getMethodByName(ctClass, "Subtraction");
		// Subtraction mutator
		SubtractionMutator sm = new SubtractionMutator();
		// Get operator '-' places
		places = new ArrayList<Integer>();
		places = sm.getPlaces(subCtMethod);
		// For each index, Run '-' mutation
		for (Integer index : places) {
			sm.substitue(subCtMethod, index);
		}
		// Run Tests 
		tr.runTests();
	}

	/////////////////////--- Division ---////////////////////
	private void runDivisionMutation() throws NotFoundException, BadBytecode, ClassNotFoundException, MalformedURLException{
		//get Division method 
		CtMethod divCtMethod = cl.getMethodByName(ctClass, "Division");
		// Division mutator
		DivisionMutator dm = new DivisionMutator();
		// Get operator '/' places
		places = new ArrayList<Integer>();
		places = dm.getPlaces(divCtMethod);
		// For each index, Run '/' mutation
		for (Integer index : places) {
			dm.substitue(divCtMethod, index);
		}
		// Run Tests 
		tr.runTests();
	}
	
	/////////////////////--- Multiplication ---////////////////////
	private void runMultiplicationMutation() throws NotFoundException, BadBytecode, ClassNotFoundException, MalformedURLException{
		//get Multiplication method 
		CtMethod multCtMethod = cl.getMethodByName(ctClass, "Multiplication");
		// Multiplication mutator
		MultiplicationMutator mm = new MultiplicationMutator();
		// Get operator '*' places
		places = new ArrayList<Integer>();
		places = mm.getPlaces(multCtMethod);
		// For each index, Run '*' mutation
		for (Integer index : places) {
			mm.substitue(multCtMethod, index);
		}
		// Run Tests 
		tr.runTests();
	}
}
