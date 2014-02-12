public class Main {

    public static void main(String[] args) {
        Table t = new Table();
	
	Player p1 = new Player();
	Player p2 = new Player();
	
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
	...
	*/
	
    }

}
