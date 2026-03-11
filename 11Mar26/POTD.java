class Solution {
    // https://leetcode.com/problems/complement-of-base-10-integer/solutions/305419/java-cpp-python-bit-manipulation/
    // TC: O(1), SC: O(1)
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = n;
        for (int i = 0; i <= 4; i++)
            mask |= mask >> (1 << i);
        return ~n & mask;
    }
}