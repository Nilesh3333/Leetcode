import Su.diameterOfBinaryTree543;

public class SymmetricTree101 {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(3);
        System.out.println(isSymmetric(node));

    }
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return mirror(root.left,root.right);
    }
    public static boolean mirror(TreeNode left, TreeNode right){
        if(left == null && right==null)
            return true;
        if(left == null || right==null)
            return false;

        return (left.val == right.val) && mirror(left.right,right.left) && mirror(left.left,right.right);
    }
}
