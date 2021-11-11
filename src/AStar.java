import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;

public abstract class AStar extends Solver{
    Node finishingNode;
    int finalCost;
    
    List<Node>neighboursList = new ArrayList<Node>();

    public AStar(ThreeByThreeBoard boardToSolve) {
        super(boardToSolve);
    }

    @Override
    public void solve() {
        // initialize frontiers and explored sets
        frontiers = new LinkedHashSet<Node>();
        explored = new LinkedHashSet<Node>();

        // initialize candidates as priority queue
        candidates = new PriorityQueue<>((obj1, obj2) -> { // compare function to compare between nodes using their f(x)
            HeuristicNode x = (HeuristicNode) obj1;
            HeuristicNode y = (HeuristicNode) obj2;
            return Double.compare(x.getF_x(), y.getF_x());
        });

        source.setCost(-1);
        /**
         *  MAIN DRIVER
         */
        AStarSolve(source);
    }

    private void AStarSolve(Node node){
        // check if already explored
        if(explored.contains(node)) return;
        explored.add(node);


        node.setCost(node.getCost()+1);

        //check if goal is found
        if(isGoalFound(node)){
            goalReached(node);
            return;
        }

        neighboursList = node.neighbours();
 
        for(int i=0; i<neighboursList.size(); i++){

            //if already in frontier then ignore
            // if not then put in priority queue
            Node neighbourNode = neighboursList.get(i);
            if(frontiers.contains(neighbourNode) || explored.contains(neighbourNode)) continue;

            //calculating f(x) = h(x) + g(x)
            double f_x = heuristic(neighbourNode)+node.getCost();

            HeuristicNode hn = new HeuristicNode(node, f_x);
            candidates.add(hn);
            frontiers.add(hn.getNode());
        }

        // complex looking, but it's only casting the pop operation from priority queue
        AStarSolve(((HeuristicNode) ((PriorityQueue<Object>) candidates).poll()).getNode());
    }

    public abstract double heuristic(Node node);

    private void goalReached(Node node){
        finalCost = node.getCost();
        System.out.println("FOUND IT!");
        finishingNode = node;
    }
}


    // PriorityQueue<HeuristicNode> pq = new PriorityQueue<HeuristicNode>(new Comparator<HeuristicNode>(){
    //     public int compare(HeuristicNode x, HeuristicNode y){
    //         if(x.getF_x() > y.getF_x()) return 1;
    //         else if(x.getF_x() < y.getF_x()) return -1;
    //         else return 0;
    //     }
    // });

            //
        // System.out.println("entered");
        //

                //
        // System.out.println("after explored!");
        //

               //
        // System.out.println(neighboursList.size());
        //
    
                    //
            // System.out.println("f(x): "+f_x);
            //