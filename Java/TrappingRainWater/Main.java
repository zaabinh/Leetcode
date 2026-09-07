class Solution {
    public static int trap(int[] height) {
        if(height.length < 2) return  0;
        int n = height.length;

        int curMax = height[0];
        int[] maxLeft = new int[n];
        maxLeft[0] = 0;
        for(int i = 1; i < n; i++) {
            maxLeft[i] = curMax;
            if(height[i] > curMax) curMax = height[i];
        }

        curMax = height[n - 1];
        int[] maxRight = new int[n];
        maxRight[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            maxRight[i] = curMax;
            if(height[i] > curMax) curMax = height[i];
        }
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans += Math.max(Math.min(maxLeft[i], maxRight[i]) - height[i], 0);

        return  ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(Solution.trap(height));
    }
}