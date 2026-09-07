class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int tank = 0;
        int total = 0;

        for(int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            tank += diff;
            total += diff;
            if(tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total >= 0 ? start : -1;
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