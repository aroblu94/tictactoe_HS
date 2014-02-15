import java.util.*;

public class Engine {

	//CAMPI
    private Player p1;
    private Player p2;
    private Table t;

	//Here the static-context. This should be re-thought!
    private static Sign[] listOfSigns = {new Cross(), new Circle()};
    private static int counter = 0;


	//COSTRUTTORE
    public Engine(Player p1, Player p2, Table t) {
        this.p1 = p1;
		this.p2 = p2;
        this.t = t;
    }
    

	//METODI
    public void update() {
    	//t.set(p1.getMovement(), p1.getSign());
		//t.set(p2.getMovement(), p2.getSign());
	
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
     
        for (Scanner in = new Scanner(System.in), lineBuffer; 
			!this.t.isFull(); this.update(), System.out.println(this)) {
			try {
				System.out.println(p1.toString());
				System.out.println("Type your choice. Format's: ...,...");
	
				// Get p1 choice
				lineBuffer = new Scanner(in.next());
				lineBuffer.useDelimiter(",");
				int r1 = Integer.parseInt(lineBuffer.next());
				int c1 = Integer.parseInt(lineBuffer.next());
				this.p1.tic(r1, c1);
			 
				System.out.println(p2.toString());
				System.out.println("Type the second player choice. Format's: ...,...");
			 
				// Get p2 choice
				lineBuffer = new Scanner(in.next());
				lineBuffer.useDelimiter(",");
				int r2 = Integer.parseInt(lineBuffer.next());
				int c2 = Integer.parseInt(lineBuffer.next());
				this.p2.tic(r2, c2);
			} 
			catch (NoSuchElementException ex) {
			    //...
				break;
			} 
			catch (ArrayIndexOutOfBoundsException ex) {
			    //...
				break;
	    	}
	    
		}

		System.out.println(this);
	
    }
    
    public Table getTable() {
        return this.t;
    }
    

    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append(p1.lastChoice() + "\n");
		sb.append(p2.lastChoice() + "\n");
		sb.append(t + "\n");
	
		return sb.toString();
    }
    
    public static Sign getNewSign() {
        return listOfSigns[counter++];
    }
}
