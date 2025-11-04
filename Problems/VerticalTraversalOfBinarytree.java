package Problems;

import java.util.*;

class Tuple {
    Node node;
    int x, y;
    public Tuple(Node node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

public class VerticalTraversalOfBinarytree {
    public static List<List<Integer>>  verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()) {
            Tuple t = q.poll();
            Node node = t.node;
            int x = t.x, y = t.y;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.data);

            if(node.left != null) q.offer(new Tuple(node.left, x - 1, y + 1));
            if(node.right != null) q.offer(new Tuple(node.right, x + 1, y + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> pq : ys.values()) {
                while(!pq.isEmpty()) col.add(pq.poll());
            }
            ans.add(col);
        }
        return ans;
     }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<List<Integer>> res = verticalTraversal(root);
        System.out.println("Vertical Order Traversal");
        for(List<Integer> list: res) {
            System.out.println(list);
        }
    }
}
