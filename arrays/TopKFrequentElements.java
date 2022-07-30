package arrays;

import java.util.HashMap;
import java.util.PriorityQueue;

// Given an integer array nums and an integer k,return the k most frequent elements.You may return the answer in any order.

public class TopKFrequentElements {
  public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }

    PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

    for (int n : map.keySet()) {
      minQ.add(n);
      if (minQ.size() > k)
        minQ.poll();
    }

    int[] topKElements = new int[k];

    int index = 0;

    while (!minQ.isEmpty()) {
      topKElements[index++] = minQ.poll();
    }

    return topKElements;
  }
}
