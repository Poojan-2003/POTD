class Solution {
    public boolean checkOnesSegment(String s) {
        //TC - O(N) where N is the length of the string s. We need to iterate through the string once to check if there is more than one segment of ones.
        // SC - O(1) as we are using only a constant amount of extra space to store the count of zeros.
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                cnt++;
            } else {
                if (cnt > 0)
                    return false;
            }
        }
        return true;
    }
}