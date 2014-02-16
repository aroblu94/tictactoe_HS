import java.util.*;

public class Engine {

    private boolean debug = false;

    public Engine(Player p1, Player p2, Table t) {
        this.p1 = p1;
	this.p2 = p2;
        this.t = t;
    }
    
    public void update() {
        t.set(p1.getMovement(), p1.getSign());
	t.set(p2.getMovement(), p2.getSign());
    }
   
    public Player findValidPath() {

        int nr = t.getNumberRows();
        int nc = t.getNumberColumns();

        Move previous = null;
        Move current = null;

        Player winner = null;
        boolean out = false;

        // Orizontal directions ...
        for (int i = 1; i <= nr; i++) {
            previous = new Move(i, 1);
            for (int j = 2; j <= nc; j++) {
                current = new Move(i, j);
		
		// DEBUG stuff ...
		if (debug) {
		    StringBuilder sb = new StringBuilder();
		    sb.append("Checking equality for positions" + " ");
		    sb.append(previous + " ");
		    sb.append("and" + " ");
		    sb.append(current + ": ");
		    sb.append(t.get(current).equals(t.get(previous))
		       && !t.get(current).equals(new Sign()));
		    System.out.println(sb.toString());
		    
		    sb = new StringBuilder();
		    sb.append("Via: ");
		    sb.append(t.get(current));
		    sb.append(" == ");
		    sb.append(t.get(previous));
		    System.out.println(sb.toString());
	        }	

                if (
		    t.get(current).equals(t.get(previous))
		       && !t.get(current).equals(new Sign())
		   )
		{
		
		    if (j > nc -1) {out = true;}
		    
                } else {
                    break;
                }
		
		previous = current;

            }
	    
            if (out != false) {
	    
	        if (p1.getSign().equals(t.get(current))) {
		    winner = p1;
		} else if (p2.getSign().equals(t.get(current))) {
		    winner = p2;
		}
		
		return winner;
	    }
	    
        }


        // Vertical directions ...
        for (int i = 1; i <= nc; i++) {
            previous = new Move(1, i);
            for (int j = 2; j <= nr; j++) {
                current = new Move(j, i);
		
		// DEBUG stuff ...
		if (debug) {
		    StringBuilder sb = new StringBuilder();
		    sb.append("Checking equality for positions" + " ");
		    sb.append(previous + " ");
		    sb.append("and" + " ");
		    sb.append(current + ": ");
		    sb.append(t.get(current).equals(t.get(previous))
		       && !t.get(current).equals(new Sign()));
		    System.out.println(sb.toString());
		    
		    sb = new StringBuilder();
		    sb.append("Via: ");
		    sb.append(t.get(current));
		    sb.append(" == ");
		    sb.append(t.get(previous));
		    System.out.println(sb.toString());
	        }
		
                if (
		    t.get(current).equals(t.get(previous))
		       && !t.get(current).equals(new Sign())
		   )
		{
		
                    if (j > nr -1) {out = true;}
		    
                } else {
                    break;
                }
		
		previous = current;
		
            }
	    
            if (out != false) {
	    
	        if (p1.getSign().equals(t.get(current))) {
		    winner = p1;
		} else if (p2.getSign().equals(t.get(current))) {
		    winner = p2;
		}
		
		return winner;
	    }
	    
        }

        // Diagonals 1, left-right starting from upper-left corner ...
        previous = new Move(1, 1);
        for (int i = 2; i <= nr; i++) {
            current = new Move(i, i);
	    
	    if (debug) {
	        StringBuilder sb = new StringBuilder();
		sb.append("Checking equality for positions" + " ");
		sb.append(previous + " ");
		sb.append("and" + " ");
		sb.append(current + ": ");
		sb.append(t.get(current).equals(t.get(previous))
		             && !t.get(current).equals(new Sign()));
		System.out.println(sb.toString());
		    
		sb = new StringBuilder();
		sb.append("Via: ");
		sb.append(t.get(current));
		sb.append(" == ");
		sb.append(t.get(previous));
		System.out.println(sb.toString());
	    }

            if (
	        t.get(current).equals(t.get(previous))
		   && !t.get(current).equals(new Sign())
	       )
	    {
                
		if (i > nr -1) {out = true;}
		
            } else {
                break;
            }
	    
	    previous = current;
	    
	    if (out != false) {
	    
	        if (p1.getSign().equals(t.get(current))) {
		    winner = p1;
		} else if (p2.getSign().equals(t.get(current))) {
		    winner = p2;
		}
		
		return winner;
	    }
	    
        }

        // Diagonals 2, left-right from upper-right corner ...
        previous = new Move(1, nc);
	for (int i = 2, j = nc -1; i <= nr; i++, j--) {
	
	    current = new Move(i, j);
	    
	    if (debug) {
	        StringBuilder sb = new StringBuilder();
		sb.append("Checking equality for positions" + " ");
		sb.append(previous + " ");
		sb.append("and" + " ");
		sb.append(current + ": ");
		sb.append(t.get(current).equals(t.get(previous))
		             && !t.get(current).equals(new Sign()));
		System.out.println(sb.toString());
		    
		sb = new StringBuilder();
		sb.append("Via: ");
		sb.append(t.get(current));
		sb.append(" == ");
		sb.append(t.get(previous));
		System.out.println(sb.toString());
	    }
	    
            if (
	        t.get(current).equals(t.get(previous))
		   && !t.get(current).equals(new Sign())
	       )
	    {
                
		if (i > nr -1) {out = true;}
		
            } else {
                break;
            }
	    
	    previous = current;
	    
	    if (out != false) {
	    
	        if (p1.getSign().equals(t.get(current))) {
		    winner = p1;
		} else if (p2.getSign().equals(t.get(current))) {
		    winner = p2;
		}
		
		return winner;
	    }
	
	}

	
        return winner;

    }

    public Player play() {
    
        Player winner = null;
     
        for (
	        Scanner in = new Scanner(System.in), lineBuffer;
	        (winner=this.findValidPath())==null && !this.t.isFull();
		this.update(), System.out.println(this)
	    )
        {
	
	    if (debug) {System.out.println("Full? " + this.t.isFull());}
	
	
	    try {
	    System.out.println("Type the first player choice. "
	       + "Format's: ...,...");
	
	    // Get p1 choice
	    lineBuffer = new Scanner(in.next());
	    lineBuffer.useDelimiter(",");
	    int r1 = Integer.parseInt(lineBuffer.next());
	    int c1 = Integer.parseInt(lineBuffer.next());
	    this.p1.tic(r1, c1);
	 
    	    System.out.println("Type the second player choice. "
	       + "Format's: ...,...");
	 
	    // Get p2 choice
	    lineBuffer = new Scanner(in.next());
	    lineBuffer.useDelimiter(",");
	    int r2 = Integer.parseInt(lineBuffer.next());
	    int c2 = Integer.parseInt(lineBuffer.next());
	    this.p2.tic(r2, c2);
	    } catch (NoSuchElementException ex) {
	        //...
		break;
	    } catch (ArrayIndexOutOfBoundsException ex) {
	        //...
		break;
	    }
	    
	}
	
	return winner;
	
    }
    
    public Table getTable() {
        return this.t;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
	sb.append(p1 + "\n");
	sb.append(p2 + "\n");
	sb.append(t);
	
	return sb.toString();
    }

    
    
    private Player p1;
    private Player p2;
    private Table t;

    // Here the static-context. This should be re-thought!
    private static Sign[] listOfSigns = {new Cross(), new Circle()};
    private static int counter = 0;
    
    public static Sign getNewSign() {
        return listOfSigns[counter++];
    }
}
