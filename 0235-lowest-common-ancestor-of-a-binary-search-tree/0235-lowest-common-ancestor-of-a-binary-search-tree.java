class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a Binary Search Tree.
     * Utilizes the BST property where left subtree values < root value < right subtree values.
     *
     * @param root The root node of the BST
     * @param p First target node
     * @param q Second target node
     * @return The lowest common ancestor node of p and q, or null if not found
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        int minValue = Math.min(p.val, q.val);
        int maxValue = Math.max(p.val, q.val);
        // Traverse the tree iteratively until we find the split point or reach null
        while (root != null) {
            if (root.val < minValue) {
                // Both nodes are in the right subtree
                root = root.right;
            } else if (root.val > maxValue) {
                // Both nodes are in the left subtree
                root = root.left;
            } else {
                // Current node is between p and q (inclusive) => LCA found
                return root;
            }
        }
        // If we exit the loop, no common ancestor was found (should not happen per problem constraints)
        return null;
    }
}