import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearchSolver extends Solver{
    public DepthFirstSearchSolver(ThreeByThreeBoard boardToSolve) {
        super(boardToSolve);
    }

    @Override
    public void solve() {
        Stack<Node> frontierStack = new Stack<>();
        frontiers = new HashSet<>();
        explored = new HashSet<>();
        frontierStack.push(source);

        Node current;
        while (!frontierStack.isEmpty()){
            current = frontierStack.pop();
            explored.add(current);

            if (isGoalFound(current)){
                solution = current;
                break;
            }

            for (Node neighbour : current.neighbours()){
                if (!frontiers.contains(neighbour) && !explored.contains(neighbour)){
                    frontiers.add(neighbour);
                    frontierStack.push(neighbour);
                }
            }
        }
    }
}
