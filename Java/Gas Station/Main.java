class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    }
}

public class Main {
    public static void main(String[] args) {
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        Solution solution = new Solution();
        int ans = solution.canCompleteCircuit(gas, cost);
        System.out.println(ans);
    }
}

// 5 1 2 3 4
// 4 4 1 5 1
// 1 -3 1 -2 3

// 1 2 3 4 5
// 3 4 5 1 2
// -2 -2 -2 3 3