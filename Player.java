public class Player {
    
    public void tic(int r, int c) {
        this.movement = new Move(r, c);
    }
    
    public Move getMovement() {
        return this.movement;
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

}
