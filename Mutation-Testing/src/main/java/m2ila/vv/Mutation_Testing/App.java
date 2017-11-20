package m2ila.vv.Mutation_Testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

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
import javassist.util.proxy.RuntimeSupport;



public class App {
	
	public static void main(String[] args ) throws ClassNotFoundException, MalformedURLException, NotFoundException, BadBytecode
	{
		ClassLoader cl = new ClassLoader();
		//Load Classes
		ClassPool pool = cl.loadClasses();
		
		  ////////////////////////////////////////////////////////////
		 ////////////		Binary Operations (+,-,*,/)		/////////
		////////////////////////////////////////////////////////////
		
		//get Binary operations class
		CtClass ctClass = cl.getCtClass(pool,"BinOperations");
		
		/////////////////////--- Addition ---////////////////////
		//get addition method 
		CtMethod addCtMethod = cl.getMethodByName(ctClass, "Addition");
		// Addition mutator
		AdditionMutator am = new AdditionMutator();
		// Get operator + places
		am.getPlaces(addCtMethod);
		// Run + mutation ! TODO substitue by index
		am.substitue(addCtMethod);
		// Run Tests 
		TestRunner tr = new TestRunner();
		tr.runTests();
		
		/////////////////////--- Substraction ---////////////////////
		//get Substraction method 
		CtMethod subCtMethod = cl.getMethodByName(ctClass, "Substraction");
		// Substraction mutator
		SubstractionMutator sm = new SubstractionMutator();
		// Get operator + places
		sm.getPlaces(subCtMethod);
		// Run - operator mutation ! TODO substitue by index
		sm.substitue(subCtMethod);
		// Run Tests 
		tr = new TestRunner();
		tr.runTests();
		
	}

}
