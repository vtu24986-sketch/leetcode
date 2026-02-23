import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            // Maintain decreasing order for maxDeque
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(nums[right]);
            
            // Maintain increasing order for minDeque
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.addLast(nums[right]);
            
            // Shrink window if difference exceeds limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left]) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == nums[left]) {
                    minDeque.pollFirst();
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}