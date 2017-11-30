package m2ila.vv.Mutation_Testing;

public enum Remplacement {

	// arithmetic opcodes tuples 
	PLUS_MINUS(99,103),
	MINUS_PLUS(103,99),
	MULT_DIV(107,111),
	DIV_MULT(111,107),

	// Comparison opcodes tuples
	LOWER_LOWEROREQUAL(156,157),
	LOWEROREQUAL_LOWER(157,156),
	GREATER_GREATEROREQUAL(158,155),
	GREATEROREQUAL_GREATER(155,158);
	
	private int InstrToReplace;
	private int InstrToInsert;
	
	Remplacement(int toReplace, int toInsert){
		this.InstrToReplace = toReplace;
		this.InstrToInsert = toInsert;
	}
	
	public int getInstrToReplace() {
		return InstrToReplace;
	}

	public int getInstrToInsert() {
		return InstrToInsert;
	}
}
