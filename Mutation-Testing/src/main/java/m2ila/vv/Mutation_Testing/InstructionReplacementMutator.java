package m2ila.vv.Mutation_Testing;

import java.util.ArrayList;
import java.util.List;

import javassist.CtMethod;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;

public class InstructionReplacementMutator {
	
	private Remplacement remp;	
	
	public InstructionReplacementMutator(Remplacement remp){
		this.remp = remp;
	}
	
	public List<Integer> getPlaces(CtMethod ctMethod) throws BadBytecode{
		//places list
		List<Integer> places =new ArrayList<Integer>();
		
		// opcode to change
		int OPCODE_TO_REPLACE = this.remp.getInstrToReplace();
		

		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
	        // Looking for opcode to substitute
	        if(_valueOfIndex8Bit==OPCODE_TO_REPLACE ) {
	            //get operator index & push it into the list
	            places.add(_indexOfCode);
	        }
	    }
	    return places;
	}
	
	public void substitue(CtMethod ctMethod, int index, boolean revert) throws BadBytecode{
		// opcode to replace
		int OPCODE_TO_REPLACE ;
		// opcode to insert
		int OPCODE_TO_INSERT ;
		
		// if revert is equal to true, we revert changes
		if(!revert){
			OPCODE_TO_REPLACE = this.remp.getInstrToReplace();
			OPCODE_TO_INSERT = this.remp.getInstrToInsert();		
		}
		else{
			OPCODE_TO_REPLACE = this.remp.getInstrToInsert();
			OPCODE_TO_INSERT = this.remp.getInstrToReplace();		
		}
		
		CodeAttribute _codeAttribute = ctMethod.getMethodInfo().getCodeAttribute();
	    CodeIterator _codeIterator = _codeAttribute.iterator();
	    
	    while (_codeIterator.hasNext()) {
	        int _indexOfCode = _codeIterator.next();
	        // if it's the right index
	        if(_indexOfCode == index){
		        int _valueOfIndex8Bit = _codeIterator.byteAt(_indexOfCode);
		        // Looking for opcode to substitute
		        if(_valueOfIndex8Bit==OPCODE_TO_REPLACE ) {
		            // Substituting opcode
		            _codeIterator.writeByte(OPCODE_TO_INSERT, _indexOfCode);
		            break;
		        }
	        }
	    }
	}

}
