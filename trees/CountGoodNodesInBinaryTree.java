package trees;

// Q) Given a binary tree root,a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

// Return the number of good nodes in the binary tree.

public class CountGoodNodesInBinaryTree {
  public int goodNodes(TreeNode root) {
    return dfs(root, root.val);
  }

  public int dfs(TreeNode root, int maxTillNow) {
    if (root == null)
      return 0;

    int res = 0;

    if (root.val >= maxTillNow) {
      res = 1;
      maxTillNow = root.val;
    } else {
      res = 0;
    }

    res += dfs(root.left, maxTillNow);
    res += dfs(root.right, maxTillNow);

    return res;

  }
}
