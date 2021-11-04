import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Node> set = new LinkedHashSet<>();

        Node node1 = new Node(new ThreeByThreeBoard(new int[]{0,1,2,3,4,5,6,7,8}), null, null);
        Node node2 = new Node(new ThreeByThreeBoard(new int[]{0,1,2,3,4,5,6,7,8}), null, null);
        Node node3 = new Node(new ThreeByThreeBoard(new int[]{0,1,2,3,4,5,6,7,8}), null, null);

        set.add(node1);
        set.add(node2);

        boolean exist = set.contains(node3);

        System.out.println(set.size());
    }
}
