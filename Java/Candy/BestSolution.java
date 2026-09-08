class Solution {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int ans = 1;
        int up = 0;
        int down = 0;
        int peak = 0;

        for (int i = 1; i < n; i++) {
            // If the current rating up
            if (ratings[i] > ratings[i - 1]) {
                // Increase up
                up++;
                // Update current highest increasing
                peak = up;
                // The value is increasing so down = 0
                down = 0;
                // Update ans = 1 (default candy) + up (current increase)
                ans += 1 + up;
            } 
            // If the current rating remain
            else if (ratings[i] == ratings[i - 1]) {
                // No increase, no decrease
                up = down = peak = 0;
                // 1 candy is enough
                ans++;
            } 
            // If the current rating decrease
            else {
                // No increase
                up = 0;
                // Increase down
                down++;
                // Update ans
                ans += 1 + down;

                // 
                if (down <= peak) {
                    ans--;
                }
            }
        }

        return ans;
    }
}

public class BestSolution {
    public static void main(String[] args) {
        int[] ratings = {1, 3, 4, 5, 2};
        int ans = Solution.candy(ratings);
        System.out.print(ans);
    }
}