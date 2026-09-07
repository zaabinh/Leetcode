class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] fw = new int[n + 1];
        int[] bw = new int[n + 1];
        fw[0] = 1;
        bw[n] = 1;
        for(int i = 1; i <= n; i++) {
            fw[i] = fw[i - 1] * nums[i - 1];
            bw[n - i] = bw[n - i + 1] * nums[n - i];
        }
        // for(int i = 0; i <= n; i++) {
        //     System.out.print(fw[i] + " ");
        // }
        // System.out.println();
        // for(int i = 0; i <= n; i++) {
        //     System.out.print(bw[i] + " ");
        // }

        int[] answer = new int[n];
        for(int i = 1; i <= n; i++) {
            answer[i - 1] = fw[i - 1] * bw[i];
        }
        return answer;
     }
}

public class Main{
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution solution = new Solution();
        int[] answer = solution.productExceptSelf(nums);
        for(int i = 0; i < answer.length; i++) System.out.print(answer[i] + " ");
    }
}
