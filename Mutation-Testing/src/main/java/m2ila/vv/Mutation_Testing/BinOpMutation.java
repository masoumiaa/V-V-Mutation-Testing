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

public class BinOpMutation {
	
	ClassLoader cl = new ClassLoader();
	TestRunner tr = new TestRunner();
	List<Integer> places;
	CtClass ctClass;
	StringBuilder sb = new StringBuilder();
	// dadd (+) opcode
	int PLUS_CODE=99;
	// dsub (-) opcode
	int MINUS_CODE=103;
	// ddiv (/) opcode
	int DIV_CODE=111;
	// dmult (*) opcode
	int MULT_CODE=107;	
	
	public void runBinOpMutations() throws NotFoundException, ClassNotFoundException, MalformedURLException, BadBytecode{
		//Load Classes
		ClassPool pool = cl.loadClasses();
		//get Binary operations class
		ctClass = cl.getCtClass(pool,"BinOperations");
		// Addition mutation
		this.runMutation("Addition");
		// Subtraction Mutation
		this.runMutation("Subtraction");
		// Division Mutation
		this.runMutation("Division");
		// Multiplication Mutation
		this.runMutation("Multiplication");
	}
	
	private void runMutation(String operation) throws NotFoundException, BadBytecode, ClassNotFoundException, MalformedURLException{
		//get method by name
		CtMethod ctMethod = cl.getMethodByName(this.ctClass, operation);
		// Get operator '+' places
		places = new ArrayList<Integer>();
		places = this.getPlaces(ctMethod);
		// For each index, Run operator mutation, run tests
		for (Integer index : places) {
			// mutation
			this.substitue(ctMethod, index);
			// write copy class
			// TODO ctClass.writeFile(); or ctClass.write(new DataOutputStream(new FileOutputStream("tempClasses/B**.class")));
			// Run Tests 
			String testReport = tr.runTests("BinOperationTest");
			this.sb.append(testReport+'\n');
		}
	}
	
	private List<Integer> getPlaces(CtMethod ctMethod) throws BadBytecode{
		
		//operation name 
		String operationName = ctMethod.getName();
		//places list
		List<Integer> places =new ArrayList<Integer>();
		
		// opcode to change
		int CODE_TO_CHANGE = 0;
		
		if(operationName == "ADDITION"){
			CODE_TO_CHANGE = PLUS_CODE;
		} else if (operationName == "Subtraction"){
			CODE_TO_CHANGE = MINUS_CODE;
		} else if (operationName == "Division"){
			CODE_TO_CHANGE = DIV_CODE;
		} else if (operationName == "Multiplication"){
			CODE_TO_CHANGE = MULT_CODE;
		}

		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
	        // Looking for opcode to substitute
	        if(_valueOfIndex8Bit==CODE_TO_CHANGE ) {
	            //get operator index & push it into the list
	            places.add(_indexOfCode);
	        }
	    }
	    return places;
	}
	
	private void substitue(CtMethod ctMethod, int index) throws BadBytecode{
		//operation name 
		String operationName = ctMethod.getName();
		// opcode to change
		int CODE_TO_CHANGE = 0;
		// opcode to change with
		int SUBSTITUTE_CODE = 0;
		
		if(operationName == "ADDITION"){
			CODE_TO_CHANGE = PLUS_CODE;
			SUBSTITUTE_CODE = MINUS_CODE;
		} else if (operationName == "Subtraction"){
			CODE_TO_CHANGE = MINUS_CODE;
			SUBSTITUTE_CODE = PLUS_CODE;
		} else if (operationName == "Division"){
			CODE_TO_CHANGE = DIV_CODE;
			SUBSTITUTE_CODE = MULT_CODE;
		} else if (operationName == "Multiplication"){
			CODE_TO_CHANGE = MULT_CODE;
			SUBSTITUTE_CODE = DIV_CODE;
		}
		
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        // if it's the right index
	        if(_indexOfCode == index){
		        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
		        // Looking for opcode to substitute
		        if(_valueOfIndex8Bit==CODE_TO_CHANGE ) {
		            // Substituting opcode
		            _codeIterator.writeByte(SUBSTITUTE_CODE, _indexOfCode);
		            break;
		        }
	        }
	    }
	}

}
