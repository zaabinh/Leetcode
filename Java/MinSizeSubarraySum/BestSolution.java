// O(n) approach using sliding window and two pointer
// If sum(left, right) < target, increase right
// While sum(left, right) >= target, increase left for smaller length

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int left = 0;
       int sum = 0;
       int ans = nums.length + 1;
       for(int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                if(right - left + 1 < ans) {
                    ans = right - left + 1;
                }
                sum -= nums[left++];
            }
       }
       if(ans == nums.length + 1) return 0;
       return ans;

    }
} 

public class BestSolution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int target = 15;
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(s.minSubArrayLen(target, nums));
    }
}