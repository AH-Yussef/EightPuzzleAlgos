public class AStarEuclidean extends AStar{

    public AStarEuclidean(ThreeByThreeBoard boardToSolve) {
        super(boardToSolve);
    }

    @Override
    public double heuristic(Node node){
        double sum = 0;
        double rowDiff;
        double colDiff;
        int[]state = node.getState();
        for(int i=0; i<9; i++){
            if(state[i] == 0) continue;
            rowDiff = Math.abs(i/3 - state[i]/3); // current row - goal row
            colDiff = Math.abs(i%3 - state[i]%3); // current col - goal col
            sum += Math.sqrt((rowDiff*rowDiff) + (colDiff*colDiff)); //root of sum of rowDiff squared + colDiff squared
        }
        return sum;
    }
}
    
    

