public class Move {

    public Move(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return this.r;
    }

    public int getC() {
        return this.c;
    }

    @Override
    public String toString() {
        return "(" + this.r
               + "," + this.c + ")";
    }

    @Override
    public boolean equals(Object other) {
        boolean out = false;

        if (other != null && other instanceof Move) {
            out =
               this.r == ((Move)other).getR() &&
                  this.c == ((Move)other).getC();
        }

        return out;
    }

    private int r;
    private int c;

}
