
package midterm;
public class Problem1 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;   
        root.left.right = root;       
        
        root.left = null;             
        root.right = null;             
        
        return newRoot;                
    }

    public void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Problem1 solution = new Problem1();
        TreeNode newRoot = solution.upsideDownBinaryTree(root);

        solution.printTree(newRoot);  
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
