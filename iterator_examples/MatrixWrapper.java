import java.util.*;

public class MatrixWrapper implements Iterable<Integer> {

    private boolean debug = false;

    public MatrixWrapper() {
        m = new Integer[nr][nc];
    }

    public Iterator<Integer> iterator() {

        final Integer[][] tmpMatrix = this.m;
        final int nr = this.nr;
        final int nc = this.nc;

        Iterator<Integer> it =
           new Iterator<Integer>()
        {

            private int r = 0;
            private int c = 0;

            @Override
            public boolean hasNext() {
                
		if (debug) {System.out.println("Looking for a new value ...");}
		
                boolean out = true;
                try {
                    out = r < nr;
                } catch (NoSuchElementException ex) {
                    out = false;
                } finally {
		    if (debug) {System.out.println("New value found: " + out);}
                    return out;
                }

            }

            @Override
            public Integer next() {

		if (debug) {System.out.println(r+","+c);}

                Integer out = null;
                
                try {
                out = tmpMatrix[r][c];
                } catch (ArrayIndexOutOfBoundsException ex) {
                    throw new NoSuchElementException();
                }

                if (c < nc -1) {
                    c++;
                } else {
                    c = 0;
                    r++;
                }
                

                return out;
            }


            @Override
            public void remove() {
                /*
                Code here ...
                */
            }
        };

        return it;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        int counter = 0;
        for (Integer i : this) {
            sb.append(i);
	    sb.append(" ");
	    
	    if (++counter >= this.nc) {
	        sb.append("\n");
		counter = 0;
	    }
        }

        // Not so clever, but ...
        return sb.delete(sb.length()-1, sb.length()).toString();

    }

    private Integer[][] m;
    private final int nr = 3;
    private final int nc = 3;

}
