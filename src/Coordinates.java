public class Coordinates {
    int row;
    int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinates shiftUp() {
        return new Coordinates(row -1, col);
    }

    public Coordinates shiftDown() {
        return new Coordinates(row +1, col);
    }

    public Coordinates shiftLeft() {
        return new Coordinates(row, col -1);
    }

    public Coordinates shiftRight() {
        return new Coordinates(row, col +1);
    }
}