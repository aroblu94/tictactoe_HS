import java.util.*;

public class Engine {

    public Engine(Player p1, Player p2, Table t) {
        this.p1 = p1;
	this.p2 = p2;
        this.t = t;
    }
    
    public void update() {
        t.set(p1.getMovement(), p1.getSign());
	t.set(p2.getMovement(), p2.getSign());
	
	/*
	 * Checking if there's a winner ...
	 */
	/* 
	boolean p1Wins = this.findValidPath(p1.getSign());
	boolean p2Wins = this.findValidPath(p2.getSign());
	
	// DEBUG ...
	
	System.out.println("DEBUG: p1Wins == " + p1Wins);
	System.out.println("DEBUG: p2Wins == " + p2Wins);
	
	//...
	*/
	
    }
    
    /*
    public boolean findValidPath(Sign s) {
    
         ...
    
    }
    */

    public void play() {       
     
        for (
	        Scanner in = new Scanner(System.in), lineBuffer;
	        !this.t.isFull();
		this.update(), System.out.println(this)
	    )
        {
	
	    try {
	    System.out.println("Type the first player choice. Format's: ...,...");
	
	    // Get p1 choice
	    lineBuffer = new Scanner(in.next());
	    lineBuffer.useDelimiter(",");
	    int r1 = Integer.parseInt(lineBuffer.next());
	    int c1 = Integer.parseInt(lineBuffer.next());
	    this.p1.tic(r1, c1);
	 
    	    System.out.println("Type the second player choice. Format's: ...,...");
	 
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
	
	System.out.println(this);
	
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

    /*
     * Here the static-context. This should be re-thought!
     */
    private static Sign[] listOfSigns = {new Cross(), new Circle()};
    private static int counter = 0;
    
    public static Sign getNewSign() {
        return listOfSigns[counter++];
    }
}
