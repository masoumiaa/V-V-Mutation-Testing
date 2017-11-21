package m2ila.vv.Mutation_Testing;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;

public class App {
	
	public static void main(String[] args ) throws ClassNotFoundException, MalformedURLException, 
											NotFoundException, BadBytecode, FileNotFoundException {
		ClassLoader cl = new ClassLoader();
		TestRunner tr = new TestRunner();
		Reporter rp = new Reporter();
		List<Integer> places;
		//init reporter
		rp.init();
		
		//Load Classes
		ClassPool pool = cl.loadClasses();
		
		  ////////////////////////////////////////////////////////////
		 ////////////	1-Binary Operations (+,-,*,/)		/////////
		////////////////////////////////////////////////////////////
		
		//get Binary operations class
		CtClass ctClass = cl.getCtClass(pool,"BinOperations");
		
		/////////////////////--- Addition ---////////////////////
		
		//get addition method 
		CtMethod addCtMethod = cl.getMethodByName(ctClass, "Addition");
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
		
		/////////////////////--- Substraction ---////////////////////
		
		//get Substraction method 
		CtMethod subCtMethod = cl.getMethodByName(ctClass, "Substraction");
		// Substraction mutator
		SubstractionMutator sm = new SubstractionMutator();
		// Get operator '-' places
		places = new ArrayList<Integer>();
		places = sm.getPlaces(subCtMethod);
		// For each index, Run '-' mutation
		for (Integer index : places) {
			sm.substitue(subCtMethod, index);
		}
		// Run Tests 
		tr.runTests();
		
		/////////////////////--- Division ---////////////////////
		
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
		
		/////////////////////--- Multiplication ---////////////////////
		
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
		
		
		  ////////////////////////////////////////////////////////////
		 ////////////		2- Remove Method Body			/////////
		////////////////////////////////////////////////////////////
		
		MethodBodyMutator mbt = new MethodBodyMutator();
		// run body remove mutation
		try {
			mbt.removeBodyMutation();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
		//TODO run tests
		
		
		  ////////////////////////////////////////////////////////////////////
		 ////////////		3- Replace Method Body by return false	/////////
		////////////////////////////////////////////////////////////////////

		// run body to return false Mutation
		try {
			mbt.replaceBodyToFalseMutation();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
		//TODO run tests
		
	}

}
