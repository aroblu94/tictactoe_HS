public class Sign {

    public Sign(char c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return Character.toString(this.c);
    }
    
    private char c;

}
