package trees;

// Q) Given a root node reference of a BST and a key,delete the node with the given key in the BST.Return the root node reference(possibly updated)of the BST.

public class DeleteNodeInaBST {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else if (root.val == key) {
      if (root.left != null && root.right != null) {
        TreeNode rmin = findMin(root.right);
        root.val = rmin.val;
        root.right = deleteNode(root.right, rmin.val);
        return root;
      } else if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;
      else {
        return null;
      }
    }
    return root;
  }

  public TreeNode findMin(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
