class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        return palindrome(str, 0, n - 1);
    }

    boolean palindrome(char[] str, int low, int high) {
        while (low < high) {
            // skip non-alphanumeric
            while (low < high && !Character.isLetterOrDigit(str[low])) {
                low++;
            }
            while (low < high && !Character.isLetterOrDigit(str[high])) {
                high--;
            }

            // compare case-insensitive
            if (Character.toLowerCase(str[low]) != Character.toLowerCase(str[high])) {
                return false;
            }

            low++;
            high--;
        }
        return true;
    }
}
