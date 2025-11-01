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

    public static Node deserialize(String data) {
        if (data.equals("")) return null;

        String[] values = data.split(" ");
        Queue<Node> queue = new LinkedList<>();

        Node root = new Node(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i < values.length; i++) {
            Node parent = queue.poll();

            if(!values[i].equals("n")) {
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }

            if(!values[++i].equals("n")) {
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
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

        Node newRoot = deserialize(data);
        System.out.println("Deserialization successful: " + (newRoot != null));
    }
}
