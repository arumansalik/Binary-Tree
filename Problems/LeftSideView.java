package Problems;

import java.util.*;

public class LeftSideView {
    public static List<Integer> leftSideView(Node root) {
        List<Integer> res = new ArrayList<>();

        leftSide(root, 0, res);

        return res;
    }

    private static void leftSide(Node node, int level, List<Integer> res) {
        if(node == null) return;

        if (level == res.size()) {
            res.add(node.data);
        }

        leftSide(node.right, level + 1, res);
        leftSide(node.left, level + 1, res);
    }
}

