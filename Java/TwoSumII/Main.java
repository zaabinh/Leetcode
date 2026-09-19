class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if(numbers[i] + numbers[j] > target) j--;
            else if(numbers[i] + numbers[j] < target) i++;
            else break;
        }
        return new int[] {i + 1, j + 1};
    }
}
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] ans = s.twoSum(numbers, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}