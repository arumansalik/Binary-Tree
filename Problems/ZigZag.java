package Problems;

import java.lang.runtime.ObjectMethods;
import java.util.*;

public class ZigZag {
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
           int size = queue.size();
           Integer[] level = new Integer[size];

           for(int i = 0; i < size; i++) {
               Node node = queue.poll();

               int index = leftToRight ? i : (size - 1 - i);
               level[index] = node.data;

               if (node.left != null) queue.offer(node.left);
               if (node.right != null) queue.offer(node.right);
           }
           result.add(Arrays.asList(level));
           leftToRight = !leftToRight;
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        System.out.println(result);
    }
}
