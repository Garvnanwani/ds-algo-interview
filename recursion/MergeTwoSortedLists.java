package recursion;

public class MergeTwoSortedLists {
  public static void main(String[] args) {

  }

  public static ListNode mergeTwoSortedLists(ListNode A, ListNode B) {
    if (A == null)
      return B;
    if (B == null)
      return A;

    if (A.val < B.val) {
      A.next = mergeTwoSortedLists(A.next, B);
      return A;
    } else {
      B.next = mergeTwoSortedLists(A, B.next);
      return B;
    }
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
