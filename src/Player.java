public class Player {
    
    public Player(Sign s) {
        this.s = s;
    }
    
    public void tic(int r, int c) {
        this.movement = new Move(r, c);
    }
    
    public Move getMovement() {
        return this.movement;
    }
    
    public Sign getSign() {
        return this.s;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
	sb.append(super.toString());
	
	sb.append(", ");
	
	sb.append("Last choice: " + this.movement);
	
	return sb.toString();
    }
    
    private Move movement;
    private Sign s;

}
