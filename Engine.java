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
	
    }
	
    /*
    public boolean findValidPath(Sign s) {
    
         ...
    
    }
    */

    public void play() {       
     
	        Scanner in = new Scanner(System.in);
			Scanner lineBuffer;

		while(1==1) {
			if(t.isFull()==false) { 
				System.out.println("Type the first player choice. Format's: ...,...");
	
				// Get p1 choice
				lineBuffer = new Scanner(in.next());
				lineBuffer.useDelimiter(",");
				int r1 = Integer.parseInt(lineBuffer.next());
				int c1 = Integer.parseInt(lineBuffer.next());
				this.p1.tic(r1, c1);
				count = count + 1;
				if(t.isFull()==false) { 
					System.out.println("Type the second player choice. Format's: ...,...");
					// Get p2 choice
					lineBuffer = new Scanner(in.next());
					lineBuffer.useDelimiter(",");
					int r2 = Integer.parseInt(lineBuffer.next());
					int c2 = Integer.parseInt(lineBuffer.next());
					this.p2.tic(r2, c2);
					count = count + 1;
				}
				else {
					System.out.println("ATTENZIONE!! Partita finita! ");
					this.update();
					System.out.println(this);
					System.exit(0);
					break;
				}
			}
			else {
				System.out.println("ATTENZIONE!! Partita finita! ");
				this.update();
				System.out.println(this);
				System.exit(0);
				break;
			}
			this.update();
			System.out.println(this);
		}
	
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
	public static int count = 0;

    /*
     * Here the static-context. This should be re-thought!
     */
    private static Sign[] listOfSigns = {new Cross(), new Circle()};
    private static int counter = 0;
    
    public static Sign getNewSign() {
        return listOfSigns[counter++];
    }
}
