import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return new AbstractList<List<Integer>>() {
            private List<List<Integer>> res;

            @Override
            public List<Integer> get(int index) {
                if (res == null) init();
                return res.get(index);
            }

            @Override
            public int size() {
                if (res == null) init();
                return res.size();
            }

            private void init() {
                res = new ArrayList<>();

                int min = nums[0];
                int max = nums[0];

                for (int x : nums) {
                    if (x < min) min = x;
                    if (x > max) max = x;
                }

                // Impossible to make 0
                if (min > 0 || max < 0) return;

                int range = max - min + 1;
                int[] count = new int[range];

                int distinct = 0;

                for (int x : nums) {
                    int idx = x - min;

                    if (count[idx]++ == 0) {
                        distinct++;
                    }
                }

                int[] unique = new int[distinct];
                int u = 0;

                for (int i = 0; i < range; i++) {
                    if (count[i] != 0) {
                        unique[u++] = i + min;
                    }
                }

                // [0, 0, 0]
                int zero = -min;

                if (zero >= 0 &&
                    zero < range &&
                    count[zero] >= 3) {

                    res.add(Arrays.asList(0, 0, 0));
                }

                for (int i = 0; i < u; i++) {
                    int a = unique[i];

                    if (a >= 0) break;

                    int ai = a - min;

                    // [a, a, c]
                    if (count[ai] >= 2) {
                        int c = -2 * a;

                        if (c <= max &&
                            count[c - min] > 0) {

                            res.add(Arrays.asList(a, a, c));
                        }
                    }

                    /*
                     * a < b <= c
                     * a + b + c = 0
                     *
                     * b <= c
                     * b <= -a - b
                     * 2b <= -a
                     */
                    int maxB = (-a) / 2;

                    for (int j = i + 1; j < u; j++) {
                        int b = unique[j];

                        if (b > maxB) break;

                        int c = -a - b;

                        if (c > max) continue;

                        int ci = c - min;

                        if (count[ci] == 0) continue;

                        if (b == c) {
                            if (count[b - min] >= 2) {
                                res.add(Arrays.asList(a, b, c));
                            }
                        } else {
                            res.add(Arrays.asList(a, b, c));
                        }
                    }
                }
            }
        };
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
    }
}