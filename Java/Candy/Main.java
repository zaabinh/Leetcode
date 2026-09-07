class Solution {
    static {
        for(int i = 0; i < 500; i++) {
            candy(new int[]{0, 0});
        }
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;

        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        int ans = candies[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1] && candies[i + 1] + 1 > candies[i]) {
                    candies[i] = candies[i + 1] + 1;
            }

            ans += candies[i];
        }
    
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] ratings = {1, 3, 4, 5, 2};
        int ans = Solution.candy(ratings);
        System.out.print(ans);
    }
}