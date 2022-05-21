package trees;

// Q) Given the root of a binary tree, return the sum of all left leaves.

public class SumOfLeftLeaves {
  public int sumOfLeftLeaves(TreeNode root) {
    int leftSum = sumOfLeftLeaves(root, false);
    return leftSum;
  }

  public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
    if (root == null)
      return 0;
    int sum = 0;
    if (root.left == null && root.right == null && isLeft)
      return root.val;

    sum += sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);

    return sum;

  }
}
