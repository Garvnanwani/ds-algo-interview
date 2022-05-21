package trees;

// Q) Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,return true if the nodes corresponding to the values x and y in the tree are cousins,or false otherwise.

// Two nodes of a binary tree are cousins if they have the same depth with different parents.

public class CousinsInBinaryTree {
  TreeNode parentLeft = null;
  TreeNode parentRight = null;
  int levelLeft = 0, levelRight = 0;

  public boolean isCousins(TreeNode root, int x, int y) {

    traverse(root, 0, null, x, y);
    if (levelLeft == levelRight && parentLeft != parentRight) {
      return true;
    }
    return false;
  }

  public void traverse(TreeNode root, int depth, TreeNode parent, int x, int y) {
    if (root == null) {
      return;
    }
    if (root.val == x) {
      parentLeft = parent;
      levelLeft = depth;
    }
    if (root.val == y) {
      parentRight = parent;
      levelRight = depth;
    }
    traverse(root.left, depth + 1, root, x, y);
    traverse(root.right, depth + 1, root, x, y);
  }
}
