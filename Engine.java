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

	/*
	 * Metto tutto in un ciclo infinito (while 1=1)
	 * e ad ogni mossa controllo che la tabella non sia piena
	 * se non è piena aumenta il count di 1 e passa alla seconda mossa
	 * e così via...
	 * il controllo lo fa la tabella stessa.
	 * il segnale di isFull viene inviato quando count = 9
	 * e a questo punto gli faccio stampare tutto per l'ultima volta
	 * e chiudo il programma con un bell System.exit(0) 
	 */

		while(1==1) {
			if(t.isFull()==false) { 
				System.out.println("Type the first player (X) choice. Format's: x,y");
	
				// Get p1 choice
				lineBuffer = new Scanner(in.next());
				lineBuffer.useDelimiter(",");
				int r1 = Integer.parseInt(lineBuffer.next());
				int c1 = Integer.parseInt(lineBuffer.next());
				//if(t.getMatrix()[r1][c1] instanceof Sign)
				//	System.out.println("Posizione occupata! ");
				//else {
					this.p1.tic(r1, c1);
					count = count + 1;
					this.update();
					System.out.println(this);
					System.out.println();
				//}					
				if(t.isFull()==false) { 
					System.out.println("Type the second player (O) choice. Format's: x,y");
					// Get p2 choice
					lineBuffer = new Scanner(in.next());
					lineBuffer.useDelimiter(",");
					int r2 = Integer.parseInt(lineBuffer.next());
					int c2 = Integer.parseInt(lineBuffer.next());
					//if(t.getMatrix()[r2][c2] instanceof Sign)
					//	System.out.println("Posizione occupata! ");
					//else {
						this.p2.tic(r2, c2);
						count = count + 1;
						this.update();
						System.out.println(this);
						System.out.println();
					//}	
				}
				else {
					System.out.println();
					System.out.println("ATTENZIONE!! Partita finita! ");
					System.exit(0);
					break;
				}
			}
			else {
				System.out.println("ATTENZIONE!! Partita finita! ");
				System.exit(0);
				break;
			}
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
		sb.append(" \n");
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
