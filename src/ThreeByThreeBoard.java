import java.util.Arrays;

public class ThreeByThreeBoard{
    private int[] tilesOrder;
    private int tilesCount;
    private int emptyTileIndex;
    private Coordinates emptyTileCo;

    public ThreeByThreeBoard(int[] state) {
        this.tilesOrder = state;
        this.tilesCount = state.length;
        this.emptyTileIndex = emptyTileIndex();
        this.emptyTileCo = tileAt(emptyTileIndex);
    }

    public int[] getTilesOrder() {
        return tilesOrder;
    }

    private int tileAt(Coordinates coordinates) {
        return 3*coordinates.row + coordinates.col;
    }

    private Coordinates tileAt(int index) {
        return new Coordinates(index /3, index %3);
    }

    private int emptyTileIndex() {
        for(int i = 0; i < this.tilesCount; i++) {
            if(tilesOrder[i] == 0) return i;
        }

        throw new RuntimeException("Error O Tile NOT FOUND!");
    }

    private int[] swap(Coordinates destCo) {
        int[] newTilesOrder = Arrays.copyOf(tilesOrder, tilesCount);
        newTilesOrder[emptyTileIndex] = tilesOrder[tileAt(destCo)];
        newTilesOrder[tileAt(destCo)] = tilesOrder[emptyTileIndex];
        return newTilesOrder;
    }

    public int[] stateAfterMovingEmptyTileUp() {
        if(emptyTileCo.row == 0) return null;

        Coordinates upTileCo = emptyTileCo.shiftUp();
        return swap(upTileCo);
    }

    public int[] stateAfterMovingEmptyTileDown() {
        if(emptyTileCo.row == 2) return null;

        Coordinates downTileCo = emptyTileCo.shiftDown();

        return swap(downTileCo);
    }

    public int[] stateAfterMovingEmptyTileLeft() {
        if(emptyTileCo.col == 0) return null;

        Coordinates leftTileCo = emptyTileCo.shiftLeft();

        return swap(leftTileCo);
    }

    public int[] stateAfterMovingEmptyTileRight() {
        if(emptyTileCo.col == 2) return null;

        Coordinates rightTileCo = emptyTileCo.shiftRight();

        return swap(rightTileCo);
    } 
}
