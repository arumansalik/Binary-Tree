package ProblemSet;

import java.util.LinkedList;
import java.util.Queue;

public class maxDepthUsingBFS {
    public static int maxDepth1(Node root) {
        if(root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            level++;
        }
        return level;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.right = new Node(6);

        int ans = maxDepth1(root);
        System.out.println(ans);
    }
}
