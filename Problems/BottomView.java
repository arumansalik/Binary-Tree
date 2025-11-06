package Problems;

import java.util.*;

class Node1 {
    int data;
    Node1 left, right;
    int hd;

    Node1(int val) {
        data = val;
        hd = 0;
        left = right = null;
    }
}

public class BottomView {
    public static ArrayList<Integer> bottomView(Node1 root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Node1> q = new LinkedList<>();

        root.hd = 0;
        q.add(root);

        while(!q.isEmpty()) {
            Node1 temp = q.remove();
            int hd = temp.hd;

            map.put(hd, temp.data);

            if(temp.left != null) {
                temp.left.hd = hd - 1;
                q.add(temp.left);
            }

            if(temp.right != null) {
                temp.right.hd = hd + 1;
                q.add(temp.right);
            }
        }

        for(int val : map.values()) ans.add(val);
        return ans;
    }
    public static void main(String[] args) {
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);
        root.right.left = new Node1(6);
        root.right.right = new Node1(7);
        root.left.right.right = new Node1(8);

        System.out.println("Bottom View of Binary Tree:");
        ArrayList<Integer> result = bottomView(root);
        System.out.println(result);
    }
}
