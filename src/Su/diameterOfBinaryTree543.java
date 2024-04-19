package Su;

public class diameterOfBinaryTree543 {
    private static int diameter =0;
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        diameterOfBinaryTree(root);
        System.out.println(diameter);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

        TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        diameter = Math.max(diameter , left+right);
        return Math.max(left,right)+1;
    }

}
