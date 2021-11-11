import java.util.*;

public abstract class Solver {
    protected Collection<Object> candidates;
    protected Set<Node> frontiers;
    protected Set<Node> explored;
    protected Node source;
    protected Node solution;

    public Solver(ThreeByThreeBoard boardToSolve) {
        this.source = new Node(boardToSolve, null, null);
    }

    public abstract void solve();

    public List<Node> findPath() {
        List<Node> path = new ArrayList<>();

        Node current = solution;
        while(current != null) {
            path.add(0, current);
            current = current.parent;
        }

        return path;
    }

    protected boolean isGoalFound(Node node) {
        int[] goalState = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        return Arrays.equals(node.getState(), goalState);
    }

    protected int getMaxDepth() {
        int maxDepth = 0;
        int cost = 0;
        for(Node node: explored) {
            cost = node.getCost();
            maxDepth = Math.max(cost, maxDepth);
        }
        return maxDepth;
    }
}
