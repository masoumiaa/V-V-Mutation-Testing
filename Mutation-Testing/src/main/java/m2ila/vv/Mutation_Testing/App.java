package m2ila.vv.Mutation_Testing;

import java.io.IOException;
import java.util.Scanner;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;

public class App {
	
	public static void main(String[] args ) throws ClassNotFoundException, NotFoundException, BadBytecode, CannotCompileException, IOException {
		
	    // Reading classes paths from System.in
		Scanner reader = new Scanner(System.in);  
		System.out.println(" ** Enter url to classes: ");
		System.out.println(" ( Example : /home/userName/workspace/VV-Mutation-Testing/inputs/ )");
		String classesUrl = reader.nextLine(); 
		
		System.out.println(" ** Enter url to project: ");
		System.out.println(" ( Example : /home/userName/workspace/VV-Mutation-Testing/Mutation-Testing/ )");
		String testsUrl = reader.nextLine(); 
		//once finished
		reader.close(); 
		
		
		//init reporter
		Reporter report = new Reporter();
		report.init();
		
		  ////////////////////////////////////////////////////////////
		 ////////////	1-Binary Operations (+,-,*,/)		/////////
		////////////////////////////////////////////////////////////
		
		OperationsMutation om = new OperationsMutation(classesUrl,testsUrl);
		// run binary operations Mutation
		om.runBinOpMutations();
		// Get BinOperation report
		String str = om.getSb().toString(); 
		report.insert(str);
		
		  ////////////////////////////////////////////////////////////////
		 ////////////	2-Comparison Operations (<,<=,>,>=)		/////////
		////////////////////////////////////////////////////////////////

		// run Comparison operations Mutation
		om.runCompOpMutations();
		// Get Comparison operations report
		str = om.getSb().toString(); 
		report.insert(str);
		
		  ////////////////////////////////////////////////////////////
		 ////////////		3- Remove Method Body			/////////
		////////////////////////////////////////////////////////////
		
		MethodBodyMutator mbt = new MethodBodyMutator(classesUrl,testsUrl);
		// run body remove mutation
		mbt.removeBodyMutation();

		// Get MethodBodyMutator Report
		str = mbt.getSb().toString(); 
		report.insert(str);
		
		  ////////////////////////////////////////////////////////////////////
		 ////////////		4- Replace Method Body by return false	/////////
		////////////////////////////////////////////////////////////////////
		
		// run body to return false Mutation
		mbt.replaceBodyToFalseMutation();
		
		// Get Mutation Report
		str = mbt.getSb().toString(); 
		report.insert(str);
		
		// Save Report 
		report.save();
		
	}

}
