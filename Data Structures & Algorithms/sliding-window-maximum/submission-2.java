
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>();  // ✅ Changed to ArrayDeque
        int l = 0, r = 0;

        while (r < n) {
            // Remove smaller elements from back
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            // Remove elements outside window
            if (l > q.getFirst()) {
                q.removeFirst();
            }

            // Add max to output when window is full
            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return output;
    }
}