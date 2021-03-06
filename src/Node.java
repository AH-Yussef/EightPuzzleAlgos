import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    private ThreeByThreeBoard state;
    private int cost;
    public Node parent;
    private Moves moveFromParent;
    List<Node> neighbours;

    public Node(ThreeByThreeBoard state, Node parent, Moves moveFromParent) {
        this.state = state;
        this.parent = parent;
        if(parent != null) this.cost = parent.cost + 1;
        this.moveFromParent = moveFromParent;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }

    public int[] getState() {
        return state.getTilesOrder();
    }

    public List<Node> neighbours() {
        neighbours = new ArrayList<>();
        addNeighbour(state.stateAfterMovingEmptyTileUp(), Moves.Up);
        addNeighbour(state.stateAfterMovingEmptyTileRight(), Moves.Right);
        addNeighbour(state.stateAfterMovingEmptyTileDown(), Moves.Down);
        addNeighbour(state.stateAfterMovingEmptyTileLeft(), Moves.Left);
        return neighbours;
    }

    private void addNeighbour(int[] state, Moves move) {
        if(state == null) return;
        else neighbours.add(new Node(new ThreeByThreeBoard(state), this, move));
    }
    /**
     *          USED FOR SETS, DO NOT TOUCH!
     */
    @Override
    public boolean equals(Object other){
        Node otherNode = (Node) other;
        return Arrays.equals(this.getState(), otherNode.getState());
    }

    @Override
    public int hashCode() {
        StringBuilder code = new StringBuilder();
        for(int n: this.getState()) code.append(n);
        return Integer.parseInt(code.toString());
    }
}
