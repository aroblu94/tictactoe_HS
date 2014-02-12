public class Table {

    public Table() {
        this.matrix = new Sign[3][3];
	
	/*
	 * Need to populate the core-matrix
	 * of Sign obj's.
	 */
	 ...
	
    }
    
    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder();

        /*
	 * Think about what kind of symbols
	 * you want to use, and append them
	 * properly.
	 */
	 ...
		
    }
    
    // Table is a wrapper for a double-dimensional
    // array of Sign objects ...
    private Sign[][] matrix;
    
    // Program is designed to work with this
    // fixed value (nr, nc), since generally
    // TicTacToe is played that way ...
    private final int nr = 3;
    private final int nc = 3;
    
}
