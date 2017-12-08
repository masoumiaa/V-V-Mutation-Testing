package m2ila.vv.Mutation_Testing;

import java.io.IOException;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;

public class App {
	
	public static void main(String[] args ) throws ClassNotFoundException, NotFoundException, BadBytecode, CannotCompileException, IOException {
		
		// Temporary urls for testing, TODO delete when coding is over
		//path to classes
		String classesUrl = "/home/aminesoumiaa/workspace/VV-Mutation-Testing/inputs/target/test-classes/";
		//path to test suites
		String testsUrl = "/home/aminesoumiaa/workspace/VV-Mutation-Testing/Mutation-Testing/";
		
		// TODO uncomment to test
		/*
	    // Reading classes paths from System.in
		Scanner reader = new Scanner(System.in);  
		System.out.println("Enter url to classes: ");
		String classesUrl = input.nextLine(); 
		
		System.out.println("Enter url to junit test suites: ");
		String testsUrl = input.nextLine(); 
		//once finished
		reader.close(); 
		*/
		
		//init reporter
		Reporter report = new Reporter();
		report.init();
		
		  ////////////////////////////////////////////////////////////
		 ////////////	1-Binary Operations (+,-,*,/)		/////////
		////////////////////////////////////////////////////////////
		
		OperationsMutation om = new OperationsMutation(classesUrl,testsUrl);
		// run binary operations Mutation
		om.runBinOpMutations();
		// TODO Get Reporter stringBuilder
		//  str = bom.getReport(); 
		//  report.insert(str);
		
		
		  ////////////////////////////////////////////////////////////////
		 ////////////	2-Comparison Operations (<,<=,>,>=)		/////////
		////////////////////////////////////////////////////////////////
		

		// run Comparison operations Mutation
		om.runCompOpMutations();
		// TODO Get Reporter stringBuilder
		//  str = bom.getReport(); 
		//  report.insert(str);
		
		  ////////////////////////////////////////////////////////////
		 ////////////		3- Remove Method Body			/////////
		////////////////////////////////////////////////////////////
		
		MethodBodyMutator mbt = new MethodBodyMutator(classesUrl,testsUrl);
		// Set Reporter stringBuilder
		// TODO mbt.setStringBuilder();
		// run body remove mutation
		try {
			mbt.removeBodyMutation();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
		// TODO Get Reporter stringBuilder
		//  str = mbt.getReport(); 
		//  report.insert(str);
		
		
		  ////////////////////////////////////////////////////////////////////
		 ////////////		4- Replace Method Body by return false	/////////
		////////////////////////////////////////////////////////////////////

		// Set Reporter stringBuilder
		// TODO mbt.setStringBuilder();
		
		// run body to return false Mutation
		mbt.replaceBodyToFalseMutation();
		
		// TODO Get Mutation Report
		//  str = mbt.getReport(); 
		//  report.insert(str);

		
		// Save Report 
		report.save();
		
	}

}
