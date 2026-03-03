class Solution {
    // TC - O(N) where N is the value of n. We are calling the function recursively
    // for n-1 until we reach the base case.
    // SC - O(N) due to the recursive call stack. In the worst case, we will have N
    // recursive calls until we reach the base case.
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int len = (1 << n) - 1;
        // System.out.println("n: " + n + " k: " + k + " len: " + len);
        // Base case: If k is in the first half of the string, we can directly find the
        // k-th bit in the first half (which is the same as the string for n-1).
        if (k < (int) Math.ceil(len / 2.0)) {
            return findKthBit(n - 1, k);
            // If k is exactly in the middle, the k-th bit is '1'.
        } else if (k == (int) Math.ceil(len / 2.0)) {
            return '1';
            // If k is in the second half, we need to find the corresponding bit in the
            // first half (which is the same as the string for n-1) and invert it.
        } else {
            char curr = findKthBit(n - 1, len - (k - 1));
            // Invert the bit: if it's '0', return '1'; if it's '1', return '0'.
            return curr == '0' ? '1' : '0';
        }
    }
}