class Solution {
    public boolean isSubsequence(String s, String t) {
        int currentIdx = 0;

        // Instead of looping through s and t, use indexOf to look for s char in t effectively
        // Use currentIdx to save lastest found index
        for (int i = 0; i < s.length(); i++) {
            // Use indexOf for best performance
            int found = t.indexOf(s.charAt(i), currentIdx);

            if (found == -1) {
                return false;
            }

            currentIdx = found + 1;
        }

        return true;
    }
}
public class BestSolution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "abc";
        String t = "ahgbjc";
        System.out.print(sol.isSubsequence(s, t));
    }
}