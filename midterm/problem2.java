
package midterm;

public class problem2 {

    private int count = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root, 0);
        return count;
    }

    private boolean isUnival(TreeNode node, int val) {
        if (node == null) return true;

        boolean left = isUnival(node.left, node.val);
        boolean right = isUnival(node.right, node.val);

        if (!left || !right) return false;
        count++;

      
        return node.val == val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        problem2 solution = new problem2();
        int result = solution.countUnivalSubtrees(root);
        System.out.println("The number of uni-value subtrees is: " + result);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
