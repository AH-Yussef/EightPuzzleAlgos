import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Set<Node> set = new LinkedHashSet<>();

//         Node node1 = new Node(new ThreeByThreeBoard(new int[]{0,1,2,3,4,5,6,7,8}), null, null);
//         Node node2 = new Node(new ThreeByThreeBoard(new int[]{0,1,2,3,4,5,6,7,8}), null, null);
//         Node node3 = new Node(new ThreeByThreeBoard(new int[]{0,1,2,3,6,5,6,7,8}), null, null);
//
//         set.add(node1);
//         set.add(node2);
//         set.add(node3);
//
//         boolean exist = set.contains(node3);

//         System.out.println(set.size());

        int[] state = {6, 4, 7, 8, 5, 0, 3, 2, 1};
        // int[] state = {4, 3, 2, 6, 5, 0, 7, 8, 1};
        // int[] state = {1, 0, 2, 3, 4, 5, 6, 7, 8};
        ThreeByThreeBoard tbt = new ThreeByThreeBoard(state);

        // AStar euclidean
        // AStarEuclidean astareuc = new AStarEuclidean(tbt);
        AStarEuclidean astareuc = new AStarEuclidean(tbt);
        Node node = new Node(tbt, null, null);
        System.out.println(astareuc.heuristic(node));
        // BFS bfs = new BFS(tbt);
        astareuc.solve();
        // for(int i=0; i<10; i++){
        //     long start = System.nanoTime();
        //     astarman.solve();
        //     long finish = System.nanoTime();
        //     System.out.println(finish-start);
        // }
        List<Node> path = astareuc.findPath();
        displayPath(path);
        System.out.println(astareuc.explored.size());
        System.out.println(astareuc.getMaxDepth());
        // Node node = new Node(tbt, null, null);
        // System.out.println(astarman.heuristic(node));
    }
    private static void displayPath(List<Node> path){
        int index=0;
        for(Node node: path) {
            System.out.print(index++ + ": ");
            for(int n: node.getState()) {
                
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

}
