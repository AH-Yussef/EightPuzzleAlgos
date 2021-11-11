import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;

public abstract class AStar extends Solver{
    
    int finalCost;
    HashMap<int[], HeuristicNode> registeredNodes = new HashMap<>();
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
        candidates = new PriorityQueue<Object>(new Comparator<Object>() {
            @Override
            public int compare(Object obj1, Object obj2) { // compare function to compare between nodes using their f(x)
                HeuristicNode x = (HeuristicNode) obj1;
                HeuristicNode y = (HeuristicNode) obj2;
                if(x.getF_x() > y.getF_x()) return 1;
                else if(x.getF_x() < y.getF_x()) return -1;
                else return 0;
            }
        });

        Node node = source;
 
        HeuristicNode hn = new HeuristicNode(node, heuristic(node) + node.getCost());
 
        candidates.add(hn);

        while(!candidates.isEmpty()){
            HeuristicNode currentNode = (HeuristicNode) ((PriorityQueue<Object>) candidates).poll();
            //
            System.out.println("SIZE: "+candidates.size());
            // checking if reached the goal
            if(isGoalFound(currentNode.getNode())){
                solution = currentNode.getNode();
                System.out.println("FOUND IT");
                break;
            }
            
            // get neighbours of the node
            neighboursList = currentNode.getNode().neighbours();
            System.out.println("BEFORE EXP");
            for(Node neighbour : neighboursList){

                if(explored.contains(neighbour)){
                    System.out.println("EXPLORED");
                    continue;
                    
                } 
                System.out.println("inside loop");
                double neighbourF_x = heuristic(neighbour) + neighbour.getCost();
                // if already exists as another node has it in its neighbours
                if(frontiers.contains(neighbour)){
                    System.out.println("inside fron");
                    // check if the we need to decrease key
                    HeuristicNode hashMapHolder = registeredNodes.get(neighbour.getState());
                    
                    // decreases key if possible
                    if(neighbourF_x < hashMapHolder.getF_x()){
                        hashMapHolder.setF_X(neighbourF_x);
                        continue;
                    }
                    // if it exists but it doesn't make the result better then we skip
                }
                // if it doesn't exist in frontier then proceed as normal
                frontiers.add(neighbour);
                candidates.add(new HeuristicNode(neighbour, neighbourF_x));
                System.out.println("added");
            }
        }
    }
    
    private void testState(Node node){
        int[] state = node.getState();
        for(int i=0; i<8; i++){
            System.out.print(state[i]);
        } 
        System.out.println();
    }
                            // if(hashMapHelper.getF_x() > neighbourF_x){
                    //     registeredNodes.get(node.getState()).setF_X(neighbourF_x);
                    // }
    
    // private void AStarSolve(Node node){
    //     // check if already explored
    //     if(explored.contains(node)) return;
    //     explored.add(node);


    //     node.setCost(node.getCost()+1);

    //     //check if goal is found
    //     if(isGoalFound(node)){
    //         goalReached(node);
    //         return;
    //     }

    //     neighboursList = node.neighbours();
 
    //     for(int i=0; i<neighboursList.size(); i++){

    //         //if already in frontier then ignore
    //         // if not then put in priority queue
    //         Node neighbourNode = neighboursList.get(i);
    //         if(frontiers.contains(neighbourNode)) continue;

    //         //calculating f(x) = h(x) + g(x)
    //         double f_x = heuristic(neighbourNode)+(node.getCost()+1);

    //         HeuristicNode hn = new HeuristicNode(node, f_x);
    //         candidates.add(hn);
    //         frontiers.add(hn.getNode());
    //     }

    //     // complex looking, but it's only casting the pop operation from priority queue
    //     AStarSolve(((HeuristicNode) ((PriorityQueue<Object>) candidates).poll()).getNode());
    // }

    public abstract double heuristic(Node node);

    // private void goalReached(Node node){
    //     finalCost = node.getCost();
    //     System.out.println("FOUND IT!");
    //     solution = node;
    // }
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