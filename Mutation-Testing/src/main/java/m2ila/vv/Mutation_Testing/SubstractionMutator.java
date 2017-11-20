package m2ila.vv.Mutation_Testing;

import java.util.ArrayList;
import java.util.List;

import javassist.CtMethod;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;

public class SubstractionMutator {

	public List<Integer> getPlaces(CtMethod ctMethod) throws BadBytecode{
		//places list
		List<Integer> places =new ArrayList<Integer>();
		// dsub (-) opcode
		int MINUS_CODE=103;
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
	        //Checking if Opcode is dsub
	        if(_valueOfIndex8Bit==MINUS_CODE ) {
	            //get operator index & push it into the list
	            places.add(_indexOfCode);
	        }
	    }
	    return places;
	}
	
	public void substitue(CtMethod ctMethod, int index) throws BadBytecode{
		// dadd (+) opcode
		int PLUS_CODE=99;
		// dsub (-) opcode
		int MINUS_CODE=103;
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        // if it's the right index
	        if(_indexOfCode == index){
		        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
		        // Checking if Opcode is dsub
		        if(_valueOfIndex8Bit==MINUS_CODE ) {
		            //Changing instruction from + to -
		            _codeIterator.writeByte(PLUS_CODE, _indexOfCode);
		            break;
		        }
	        }
	    }
	}
}
