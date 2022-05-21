package trees;

// Q) Given an integer array nums where the elements are sorted in ascending order,convert it to a height-balanced binary search tree.

// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

public class ConvertSortedArrayToBST {
  public TreeNode sortedArrayToBST(int[] nums) {

    return sortedArrayToBST(nums, 0, nums.length - 1);

  }

  TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    if (start > end) {
      return null;
    }

    int mid = start + (end - start) / 2;
    TreeNode node = new TreeNode(nums[mid]);

    node.left = sortedArrayToBST(nums, start, mid - 1);
    node.right = sortedArrayToBST(nums, mid + 1, end);

    return node;
  }

}
