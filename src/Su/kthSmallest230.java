package Su;

public class kthSmallest230 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(ksmallest(root,3));
    }
    private static int value = 0;
    private static int count=1;
    private static int ksmallest(TreeNode root, int i) {
        if(root == null)
            return 0;
        ksmallest(root.left,i);
        if(count == i)
            value = root.data;
        count++;
        ksmallest(root.right,i);
        return value;
    }

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
