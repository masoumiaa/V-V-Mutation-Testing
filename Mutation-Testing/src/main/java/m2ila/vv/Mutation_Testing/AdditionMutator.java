package m2ila.vv.Mutation_Testing;

import java.util.ArrayList;
import java.util.List;

import javassist.CtMethod;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;

public class AdditionMutator {

	public List<Integer> getPlaces(CtMethod ctMethod) throws BadBytecode{
		//places list
		List<Integer> places =new ArrayList<Integer>();
		// dadd (+) opcode
		int PLUS_CODE=99;
		// dsub (-) opcode
		int MINUS_CODE=103;
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
	        //Checking if Opcode is +
	        if(_valueOfIndex8Bit==PLUS_CODE ) {
	            //get operator index & push it into the list
	            places.add(_indexOfCode);
	        }
	    }
	    return places;
	}
	
	public void substitue(CtMethod ctMethod) throws BadBytecode{
		// dadd (+) opcode
		int PLUS_CODE=99;
		// dsub (-) opcode
		int MINUS_CODE=103;
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
	        //Checking if Opcode is +
	        if(_valueOfIndex8Bit==PLUS_CODE ) {
	            //Changing instruction from + to -
	            _codeIterator.writeByte(MINUS_CODE, _indexOfCode);
	        }
	    }
	}
}
