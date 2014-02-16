public class Sign {

    public Sign() {
        this.c = ' ';
    }

    public Sign(char c) {
        this.c = c;
    }

    public char getChar() {
        return this.c;
    }

    @Override
    public boolean equals(Object s) {
        boolean out = false;

        if (s instanceof Sign) {
            out = ((Sign)s).getChar() == this.c;
        }

        return out;
    }

    @Override
    public String toString() {
        return Character.toString(this.c);
    }
    
    private char c;

}
