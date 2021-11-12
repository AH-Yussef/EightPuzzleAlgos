import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

abstract class AStar extends Solver{
    PriorityQueue<HeuristicNode> pq;
    List<Node>neighbours = new ArrayList<Node>();
    public AStar(ThreeByThreeBoard boardToSolve) {
        super(boardToSolve);
        
    }

    @Override
    public void solve() {
        frontiers = new HashSet<>();
        explored = new HashSet<>();
        pq = new PriorityQueue<HeuristicNode>(new Comparator<HeuristicNode>(){
            @Override
            public int compare(HeuristicNode hn1, HeuristicNode hn2) {
                if(hn1.getF_x() > hn2.getF_x()) return 1;
                if(hn1.getF_x() < hn2.getF_x()) return -1;
                return 0;
            }
        });

        pq.add(new HeuristicNode(source, source.getCost() + heuristic(source)));

        while(!pq.isEmpty()){
            HeuristicNode currentHeuristicNode = pq.poll();
            Node node = currentHeuristicNode.getNode();

            explored.add(node);

            if(isGoalFound(node)){
                solution = node;
                System.out.println("FOUND IT!");
                break;
            }

            neighbours = node.neighbours();
            for(Node neighbour : neighbours){
                if(!explored.contains(neighbour)){
                HeuristicNode neighboHeuristicNode = new HeuristicNode(neighbour, heuristic(neighbour) + neighbour.getCost());
                pq.add(neighboHeuristicNode);
                }
            }
        }
    }

    protected abstract double heuristic(Node node);
}
