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
		//init reporter
		Reporter report = new Reporter();
		report.init();
		
		  ////////////////////////////////////////////////////////////
		 ////////////	1-Binary Operations (+,-,*,/)		/////////
		////////////////////////////////////////////////////////////
		
		BinOpMutation bom = new BinOpMutation();
		// run binary operations Mutation
		bom.runBinOpMutations();
		// TODO Get Reporter stringBuilder
		//  str = bom.getReport(); 
		//  report.insert(str);
		
		  ////////////////////////////////////////////////////////////
		 ////////////		2- Remove Method Body			/////////
		////////////////////////////////////////////////////////////
		
		MethodBodyMutator mbt = new MethodBodyMutator();
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
		//TODO run tests
		
		
		  ////////////////////////////////////////////////////////////////////
		 ////////////		3- Replace Method Body by return false	/////////
		////////////////////////////////////////////////////////////////////

		// Set Reporter stringBuilder
		// TODO mbt.setStringBuilder();
		// run body to return false Mutation
		try {
			mbt.replaceBodyToFalseMutation();
		} catch (CannotCompileException e) {
			e.printStackTrace();
		}
		// TODO Get Mutation Report
		//  str = mbt.getReport(); 
		//  report.insert(str);
		//TODO run tests
		
		// Save Report 
		report.save();
		
	}

}
