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

        int[] state = {4,3,2,6,5,0,7,8,1};
        ThreeByThreeBoard tbt = new ThreeByThreeBoard(state);
        BFS bfs = new BFS(tbt);
        bfs.solve();
        List<Node> path = bfs.findPath();


        for(Node node: path) {
            for(int n: node.getState()) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

}
