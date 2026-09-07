class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
    
        k %= n;
        
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}

public class BestSolution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solve = new Solution();
        solve.rotate(nums, k);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
