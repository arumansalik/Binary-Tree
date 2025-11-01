package Problems;

import java.util.*;

public class SerializeDeserializeTree {
    public static String serialize(Node root) {
         if(root == null) return "";

        Queue<Node> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node == null) {
                res.append("n ");
                continue;
            }

            res.append(node.data + " ");
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // Build the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String data = serialize(root);
        System.out.println("Serialized Tree: " + data);
    }
}
