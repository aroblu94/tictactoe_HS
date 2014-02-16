import java.util.*;

public class Main {

    public static void main(String[] args) {
        Table t = new Table();
	
	Player p1 = new Player(Engine.getNewSign());
	Player p2 = new Player(Engine.getNewSign());
	
	Engine e = new Engine(p1, p2, t);

        Player winner = e.play();

        System.out.println("Winner is: " + winner);

    }

}
