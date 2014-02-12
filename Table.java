public class Table {

    public Table() {
        this.matrix = new Sign[3][3];
	
	/*
	 * Need to populate the core-matrix
	 * of Sign obj's.
	 * ...
	 */
	
    }
    
    public void set(Move m) {
        try {
            this.matrix[m.getR() -1][m.getC() -1] = new Sign('*');
	} catch (NullPointerException e) {
	    //...
	}
    }
    
    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder();

        /*
	 * Think about what kind of symbols
	 * you want to use, and append them
	 * properly.
	 * ...
	 */
	 
	 /*
	  * We're now using a map-like way
	  * to present the table, since we
	  * are still designing the game.
	  */
	 for (int r = 0; r < this.nr; r++) {
	     for (int c = 0; c < this.nc; c++) {
	         sb.append("(" + (r+1) + "," + (c+1) + ") -> " + this.matrix[r][c]);
		 sb.append("\n");
	     }
	     
	     if (r < this.nr -1) {
	         sb.append("\n");
             }
	 } 
	 
	 return sb.toString();
		
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
