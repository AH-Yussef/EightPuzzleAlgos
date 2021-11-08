public class HeuristicNode {
    private Node node;
    private double f_x;

    public HeuristicNode(Node node, double val){
        this.node = node;
        f_x = val;
    }
    public Node getNode(){
        return node;
    }
    public double getF_x(){
        return f_x;
    }
}
