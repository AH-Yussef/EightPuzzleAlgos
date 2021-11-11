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
        // int[] state = {1, 0, 2, 3, 4, 5, 6, 7, 8};
        ThreeByThreeBoard tbt = new ThreeByThreeBoard(state);
        // // BFS bfs = new BFS(tbt);
        // // bfs.solve();
        AStarEuclidean astareuc = new AStarEuclidean(tbt);
        astareuc.solve();
        List<Node> path = astareuc.findPath();

        int index=0;
        for(Node node: path) {
            System.out.print(index++ + ": ");
            for(int n: node.getState()) {
                
                System.out.print(n + " ");
            }
            System.out.println();
        }
        // Node node = new Node(tbt, null, null);
        // System.out.println(astarman.heuristic(node));
    }

}
