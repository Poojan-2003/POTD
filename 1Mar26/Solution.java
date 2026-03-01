class Solution {
    // TC - O(N) where N is the length of the string n. We need to iterate through the string once to find the maximum digit.
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(max, n.charAt(i) - '0');
            if (max == 9)
                return max;
        }
        return max;
    }
}