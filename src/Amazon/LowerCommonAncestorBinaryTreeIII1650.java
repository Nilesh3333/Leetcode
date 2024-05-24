package Amazon;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.HashSet;

public class LowerCommonAncestorBinaryTreeIII1650 {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.parent = root;
        root.right.parent = root;

        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;

        root.right.left = new Node(0);
        root.right.right = new Node(8);
        root.right.left.parent = root.right;
        root.right.right.parent = root.right;

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.left.right.left.parent = root.left.right;
        root.left.right.right.parent = root.left.right;

        // Nodes p and q
        Node p = root.left; // Node with value 5
        Node q = root.right; // Node with value 4

        // Find LCA
        Node lca = lowestCommonAncestor1(p, q);

        // Print the result
        System.out.println(STR."LCA of \{p.val} and \{q.val} is: \{lca.val}");
    }

    /*Time Complexity: O(n)  Space Complexity: O(n)*/
    private static Node lowestCommonAncestor2(Node p,Node q){
        HashSet<Node> set = new HashSet<>();
        while(p !=null){
            set.add(p);
            p = p.parent;
        }
        while (q!=null){
            if(set.contains(q))
                return q;
            q= q.parent;
        }
        return null;
    }

    //Time - O(h) (best case) to O(d) d-depth of the tree     Space - O(1)
    private static Node lowestCommonAncestor1(Node p, Node q) {
        Node a = p;
        Node b = q;
        while(a != b){
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;

    public Node(int val) {
        this.val = val;
    }
}