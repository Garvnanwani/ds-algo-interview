package trees;

// Q) Given the root of a binary tree,return its maximum depth.

// A binary tree'smaximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

public class MaxDepthInBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);

    return 1 + Math.max(leftDepth, rightDepth);
  }
}
