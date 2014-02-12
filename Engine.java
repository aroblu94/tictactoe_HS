public class Engine {

    public Engine(Player p1, Player p2, Table t) {
        this.p1 = p1;
	this.p2 = p2;
        this.t = t;
    }
    
    public void update() {
        t.set(p1.getMovement());
	t.set(p2.getMovement());
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

}
