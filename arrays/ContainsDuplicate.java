package arrays;
import java.util.HashSet;

// Q) Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// TC - O(n)
// SC - O(n)

public class ContainsDuplicate {
  public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();

    for (int i : nums) {
      if (set.contains(i)) {
        return true;
      }

      set.add(i);
    }

    return false;
  }
}

// Other methods include using 2 loops, sorting and comparing side by side
