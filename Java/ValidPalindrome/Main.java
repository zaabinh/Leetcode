class Solution {
    public boolean isPalindrome(String s) {
        char[] normalized = new char[s.length()];
        int index = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) {
                normalized[index++] = Character.toLowerCase(ch);
            }
        }
        int i = 0;
        int j = index - 1;
        // System.out.println(new String(normalized, 0, index));
        while(i < j) {
            if(normalized[i++] != normalized[j--]) return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(s.isPalindrome(str));
    }
}