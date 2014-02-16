import java.util.*;

public class Table implements Iterable<Sign> {

    private boolean debug = false;

    public Table() {
        this.matrix = new Sign[nr][nc];
	for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                this.matrix[i][j] = new Sign();
            }
        }
    }
    
    public void set(Move m, Sign s) {
        try {
            if (!this.isUnset(m))
	        return;

	    this.matrix[m.getR() -1][m.getC() -1]= s;
	} catch (NullPointerException e) {
	    System.err.println(e.getMessage());
	}
    }

    public boolean isUnset(Move m) {
        if (this.get(m).equals(new Sign()))
            return true;
        else
            return false;
    }
    
    public Sign get(Move m) {
        return this.matrix[m.getR() -1][m.getC() -1];
    }

    public Iterator<Sign> iterator() {
    
        final Sign[][] tmpMatrix = this.matrix;
	final int nr = this.nr;
	final int nc = this.nc;
    
        Iterator<Sign> it = new Iterator<Sign>() {
	
	    private int rowIndex = 0;
	    private int colIndex = 0;
	
	    @Override
	    public boolean hasNext() {
	        boolean out = false;
		
		if (rowIndex < nr && colIndex < nc) {
		    out = true;
		}
		
		return out;
	    }
	    
	    @Override
	    public Sign next() {
	        Sign out = null;

                if (debug) {
		    System.out.println("Returning element at "
		       + "(" + rowIndex + "," + colIndex + ")");
		}
		
		try {
        	out = tmpMatrix[rowIndex][colIndex];
		    
		if (colIndex < nc -1) {
		    colIndex++;
		} else if (rowIndex < nr -1) {
		    colIndex = 0;
		    rowIndex++;
		} else {
		    // Causing volontary out-of-bounds ...
		    rowIndex++;
		    colIndex++;
		}
		} catch (ArrayIndexOutOfBoundsException ex) {
		    throw new NoSuchElementException();
		}

		return out;
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

    public boolean isFull() {
        boolean out = true;
	
	for (Sign s : this) {
	    if (s.equals(new Sign())) {
	        out = false;
		break;
	    }
	}
	
	return out;
    }

    @Override
    public String toString() {
    
        StringBuilder sb = new StringBuilder();

        /*
        for (int r = 0; r < this.nr; r++) {
	     for (int c = 0; c < this.nc; c++) {
	     
	         //
		 // If the current position is not
		 // already set, does not print 'null'
		 // but just a white-space instead ...
	         if (matrix[r][c] != null) {
		     sb.append(matrix[r][c]);
		 } else {
		     sb.append(" ");
		 }
		 
		 
		 // After every element, except the last one
		 // print a bar for each row...
		 if (c < this.nc -1) {
		     sb.append("|");
		 }
		 
	     }
	     
	     //
	     // Once you've printed an entire row
	     // always append a newline character...
	     //
	     
	     //sb.append("\n");
	     
	     // If you're printing the last row, does not append
	     // a newline character. That's for giving people
	     // using this class the possibility of using
	     // System.out.println() withouth bothering
	     // too much about hidden empty line that
	     // magically appear at runtime ...
	     //
	     
	     if (r < this.nr -1) {
	         sb.append("\n");
	         for (int counter = 0; counter++ < this.nc + this.nc -1; sb.append("="));
	         sb.append("\n");
             }
	   
	}
	*/
	 
	 // Decomment for using a map-like way
	 // to represent the table. I found that
	 // useful at the beginning.
	 for (int r = 0; r < this.nr; r++) {
	     for (int c = 0; c < this.nc; c++) {
	         sb.append("(" + (r+1) + "," + (c+1) + ") "
                    +"-> " + this.matrix[r][c]);
		 sb.append("\n");
	     }
	     
	     if (r < this.nr -1) {
	         sb.append("\n");
             }
	    
	 }
	 
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
    
    // Program is designed to work with this
    // fixed value (nr, nc), since generally
    // TicTacToe is played that way ...
    private final int nr = 3;
    private final int nc = 3;
    
}
