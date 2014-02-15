import java.util.*;

public class Table /*implements Iterable<Sign>*/ {

    public Table() {
        this.matrix = new Sign[3][3];
	
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
    
    public Sign get(Move m) {
        return this.matrix[m.getR() -1][m.getC() -1];
    }

    /*
    public Iterator<Sign> iterator() {
    
        final Sign[][] tmpMatrix = this.matrix;
    
        Iterator<Sign> it = new Iterator<Sign>() {
	
	    @Override
	    public boolean hasNext() {
	        // Code here ...
	    }
	    
	    @Override
	    public Sign next() {
	        // Code here ...
	    }
	    
	    @Override
	    public void remove() {
	        // Code here ...
	    }
	    
    	    private int r = 0;	
	    private int c = 0;
	   
	};
	
	return it;
    
    }
    */

    public boolean isFull() {
        if (Engine.count==9)
			isFull = true;
		else 
			isFull = false;
		return isFull;
    }

    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder();

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
		  * print a bar for each row...
		  */
		 if (c < this.nc -1) {
		     sb.append("|");
		 }
	     }
	     
	     /*
	      * Once you've printed an entire row
	      * always append a newline character...
	      */
	     
	     //sb.append("\n");
	     
	     /*
	      * If you're printing the last row, does not append
	      * a newline character. That's for giving people
	      * using this class the possibility of using
	      * System.out.println() withouth bothering
	      * too much about hidden empty line that
	      * magically appear at runtime ...
	      */
             if (r < this.nr -1) {
	         sb.append("\n");
	         for (int counter = 0; counter++ < this.nc + this.nc -1; sb.append("="));
	         sb.append("\n");
             }
	}
	 
	 /*
	  * Decomment for using a map-like way
	  * to represent the table. I found that
	  * useful at the beginnin.
	  */
	 /* 
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
    
    public int getNumberRows() {
        return nr;
    }
    
    public int getNumberColumns() {
        return nc;
    }
    
    // Table is a wrapper for a double-dimensional
    // array of Sign objects ...
    private Sign[][] matrix;
	private boolean isFull = false;
    
    // Program is designed to work with this
    // fixed value (nr, nc), since generally
    // TicTacToe is played that way ...
    private final int nr = 3;
    private final int nc = 3;
    
}
