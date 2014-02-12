public class Table {

    public Table() {
        this.matrix = new Sign[3][3];
	
	/*
	 * Need to populate the core-matrix
	 * of Sign obj's.
	 * ...
	 */
	
    }
    
    public void set(Move m, Sign s) {
        try {
            if(this.matrix[m.getR() -1][m.getC() -1] != null)
	        return;

	    this.matrix[m.getR() -1][m.getC() -1]= s;
	} catch (NullPointerException e) {
	    //...
	}
    }
    
    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder();

        /*
	 * Pretty printing here ...
	 */
        for (int r = 0; r < this.nr; r++) {
	     for (int c = 0; c < this.nc; c++) {
	     
	         /*
		  * If the current position is not
		  * already set, does not print 'null'
		  * but just a white-space instead ...
		  */
	         if (matrix[r][c] != null) {
		     sb.append(matrix[r][c]);
		 } else {
		     sb.append(" ");
		 }
		 
		 /*
		  * After every element, except the last one
		  * for each row, print a bar ...
		  */
		 if (c < this.nc -1) {
		     sb.append("|");
		 }
	     }
	     
	     /*
	      * Always append a newline character, once
	      * you've printed an entire row ...
	      */
	     sb.append("\n");
	     
	     /*
	      * Print a line of '=', as a separator ...
	      */
	     for (int counter = 0; counter++ < this.nc + this.nc -1;)
	         sb.append("=");
	     
	     /*
	      * If you're printing the last row, does not append
	      * a newline character. That's for giving people
	      * using this class the possibility of using
	      * System.out.println() withouth bothering
	      * too much about hidden empty line that
	      * magically appear at runtime ...
	      */ 
             if (r < this.nr -1)
	         sb.append("\n");
	}
	 
	 /*
	  * We're now using a map-like way
	  * to present the table, since we
	  * are still designing the game.
	 for (int r = 0; r < this.nr; r++) {
	     for (int c = 0; c < this.nc; c++) {
	         sb.append("(" + (r+1) + "," + (c+1) + ") -> " + this.matrix[r][c]);
		 sb.append("\n");
	     }
	     
	     if (r < this.nr -1) {
	         sb.append("\n");
             }
	 }
	 */ 
	 
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
