import java.util.*;

public class MatrixWrapper implements Iterable<Integer> {

	//CAMPI
	private Integer[][] m;
    private final int nr = 3;
    private final int nc = 3;

    private boolean debug = false;


	//COSTRUTTORE
    public MatrixWrapper() {
        m = new Integer[nr][nc];
    }


	//METODI
    public Iterator<Integer> iterator() {

        final Integer[][] tmpMatrix = this.m;
        final int nr = this.nr;
        final int nc = this.nc;

        Iterator<Integer> it = new Iterator<Integer>()
        {
            private int r = 0;
            private int c = 0;

            public boolean hasNext() {
                
				if (debug) 
					System.out.println("Looking for a new value ...");
		
                boolean out = true;
                try {
                    out = r < nr;
                } 
				catch (NoSuchElementException ex) {
                    out = false;
                } 	
				finally {
		    		if (debug) 
						System.out.println("New value found: " + out);
                    return out;
                }

            }

            public Integer next() {

				if (debug) 
					System.out.println(r+","+c);

                Integer out = null;
                
                try {
                	out = tmpMatrix[r][c];
                } 
				catch (ArrayIndexOutOfBoundsException ex) {
                    throw new NoSuchElementException();
                }

                if (c < nc -1) {
                    c++;
                } 
				else {
                    c = 0;
                    r++;
                }
                
                return out;
            }

            public void remove() {
                /*
                Code here ...
                */
            }
        };

        return it;

    }


    public String toString() {

        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (Integer i : this) {
            sb.append(i);
	    	sb.append(" ");
	    
	    	if (++counter == this.nc) {	//qui basta ==, non è necessario >=
	        	sb.append("\n");
				counter = 0;
	    	}
        }
        						// Qui basta questo
        					 	// sb.delete(sb.length()-1, 
		return sb.toString();	//		sb.length()).toString();
								// non è necessario...
								// Just a bit more clever ;)
    }

}
