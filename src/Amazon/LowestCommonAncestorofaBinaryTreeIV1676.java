package Amazon;

import Su.maxDepth104;

import javax.swing.tree.TreeNode;

//Time O(n*k)   space O(h)
public class LowestCommonAncestorofaBinaryTreeIV1676 {
    public static void main(String[] args) {

    }
    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        if(root == null) return null;
        for(TreeNode node : nodes){
            if(root == node)
                return node;
        }
        TreeNode left = lowestCommonAncestor( root.left,  nodes);
        TreeNode right = lowestCommonAncestor( root.right, nodes);
        if( left != null && right != null) return root;
        return left != null ? left : right;
    }*/
}
