import java.util.*;

public class Main {

    public static void main(String[] args) {
        Table t = new Table();
	
	Player p1 = new Player(Engine.getNewSign());
	Player p2 = new Player(Engine.getNewSign());
	
	Engine e = new Engine(p1, p2, t);
	
	p1.tic(1, 3);
		
	e.update();
	
	p2.tic(2, 3);
	
	e.update();
	
	p1.tic(1, 2);
	p1.tic(1, 1);
	
	e.update();
	
	// DEBUG ...
	System.out.println(e);
	
	
	/*
	 * This loop is here just for giving few ideas.
	 * It's not stable, neither good-looking ...
	 */
	/*
        for (
	        Scanner in = new Scanner(System.in), lineBuffer;
	        !e.getTable().isFull();
		e.update(), System.out.println(e)
	    )
        {
	
	    try {
	    System.out.println("Type the first player choice. Format's: ...,...");
	
	    // Get p1 choice
	    lineBuffer = new Scanner(in.next());
	    lineBuffer.useDelimiter(",");
	    int r1 = Integer.parseInt(lineBuffer.next());
	    int c1 = Integer.parseInt(lineBuffer.next());
	    p1.tic(r1, c1);
	 
    	    System.out.println("Type the second player choice. Format's: ...,...");
	 
	    // Get p2 choice
	    lineBuffer = new Scanner(in.next());
	    lineBuffer.useDelimiter(",");
	    int r2 = Integer.parseInt(lineBuffer.next());
	    int c2 = Integer.parseInt(lineBuffer.next());
	    p2.tic(r2, c2);
	    } catch (NoSuchElementException ex) {
	        //...
		break;
	    } catch (ArrayIndexOutOfBoundsException ex) {
	        //...
		break;
	    }
	    
	}
	*/
	
    }

}
