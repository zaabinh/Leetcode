// O(nlogn) approach using binary search and prefix sum array

class Solution {
    private int getRangeSum(int[] prefix, int l, int r) {
        if(l == 0) return prefix[r];
        return prefix[r] - prefix[l - 1];
    }
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[] prefix = new int[n];
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            prefix[i] = sum;
            // System.out.print(prefix[i] + " ");
        }
        // System.out.println();
        if(sum < target) return 0;
        int l = 1;
        int r = n;
        int ans = 0;
        while(l <= r) { 
            int mid = (l + r) / 2;
            boolean ok = false;
            for(int i = mid - 1; i < n; i++) {
                int s = getRangeSum(prefix, i - mid + 1, i);
                // System.out.println(i - mid + 1 + " " + i + " " + s);
                if(s >= target) {
                    ok = true;
                    break;
                }
            }
            if(ok) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(s.minSubArrayLen(target, nums));
    }
}