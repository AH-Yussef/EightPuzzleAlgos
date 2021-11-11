public class AStarEuclidean extends AStar{

    public AStarEuclidean(ThreeByThreeBoard boardToSolve) {
        super(boardToSolve);
    }

    @Override
    protected double heuristic(Node node) {
        int[][] twoDgrid = oneDtwoD(node.getState());
        double sum = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(twoDgrid[i][j] == 0) continue;

                double rowDiff = Math.abs(i - twoDgrid[i][j]/3);
                double colDiff = Math.abs(j - twoDgrid[i][j]%3);

                sum += Math.sqrt(Math.pow(rowDiff, 2) + Math.pow(colDiff, 2));
            }
        }
        return sum;
    }
    
    
}
