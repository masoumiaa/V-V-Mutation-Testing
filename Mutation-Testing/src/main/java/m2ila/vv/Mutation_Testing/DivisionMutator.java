package m2ila.vv.Mutation_Testing;

import java.util.ArrayList;
import java.util.List;

import javassist.CtMethod;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;

public class DivisionMutator {

	public List<Integer> getPlaces(CtMethod ctMethod) throws BadBytecode{
		//places list
		List<Integer> places =new ArrayList<Integer>();
		// ddiv (/) opcode
		int DIV_CODE=111;
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
	        //Checking if Opcode is ddiv
	        if(_valueOfIndex8Bit==DIV_CODE ) {
	            //get operator index & push it into the list
	            places.add(_indexOfCode);
	        }
	    }
	    return places;
	}
	
	public void substitue(CtMethod ctMethod, int index) throws BadBytecode{
		// ddiv (/) opcode
		int DIV_CODE=111;
		// dmult (*) opcode
		int MULT_CODE=107;
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        // if it's the right index
	        if(_indexOfCode == index){
		        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
		        // Checking if Opcode is ddiv
		        if(_valueOfIndex8Bit==DIV_CODE ) {
		            //Changing instruction from / to *
		            _codeIterator.writeByte(MULT_CODE, _indexOfCode);
		            break;
		        }
	        }
	    }
	}
}
