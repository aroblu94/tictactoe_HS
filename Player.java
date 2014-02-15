public class Player {
    
	//CAMPI
	//private Move movement;
    private Sign s;

	//COSTRUTTORE
    public Player(Sign s) {
        this.s = s;
    }
    
	//METODI
    public void tic(int r, int c) {
        //this.movement = new Move(r, c);
    }
    
    /*public Move getMovement() {
        return this.movement;
    }*/
    
    public Sign getSign() {
        return this.s;
    }
    

    public String toString() {
        StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
	
		sb.append(", ");
	
		sb.append("Last choice: ");// + this.movement);
	
		return sb.toString();
    }

}
