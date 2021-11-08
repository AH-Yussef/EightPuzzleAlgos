public class AStarManhattan extends AStar {

    public AStarManhattan(ThreeByThreeBoard boardToSolve) {
        super(boardToSolve);
        
    }

    @Override
    public double heuristic(Node node) {
        int[][] twoDgrid = oneDtwoD(node.getState());
        double sum = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                //          vertical difference             horizontal difference
                sum += Math.abs(i-twoDgrid[i][j]/3) + Math.abs(j - twoDgrid[i][j]%3);
            }
        }
        return sum;
    }
    
    private int[][] oneDtwoD(int[]oneDgrid){
        int[][] twoDgrid = new int[3][3];
        int index= 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                twoDgrid[i][j] = oneDgrid[index++];
            }
        }
        return twoDgrid;
    }
}
