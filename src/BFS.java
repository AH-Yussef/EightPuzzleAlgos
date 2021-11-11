import java.util.*;

public class BFS extends Solver{
    public BFS(ThreeByThreeBoard boardToSolve) {
        super(boardToSolve);
    }

    @Override
    public void solve() {
        Queue<Node> frontierStack = new LinkedList<>();
        frontiers = new HashSet<>();
        explored = new HashSet<>();
        frontierStack.add(source);

        Node current;
        while (!frontierStack.isEmpty()){
            current = frontierStack.poll();
            explored.add(current);

            if (isGoalFound(current)){
                solution = current;
                break;
            }

            for (Node neighbour : current.neighbours()){
                if (!frontiers.contains(neighbour) && !explored.contains(neighbour)){
                    frontiers.add(neighbour);
                    frontierStack.add(neighbour);
                }
            }
        }
    }
}
