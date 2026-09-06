class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n]; 
        
        for(int i = 0; i < n; i++) {
            result[(i + k) % n] = nums[i];
        }
        
        System.arraycopy(result, 0, nums, 0, n);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution solve = new Solution();
        solve.rotate(nums, k);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " "); // Output will now correctly be: 5 6 7 1 2 3 4
    }
}
