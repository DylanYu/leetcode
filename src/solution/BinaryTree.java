package solution;

public class BinaryTree {
    public static TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
//        root.right.right = new TreeNode(18);
        return root;
    }
}
