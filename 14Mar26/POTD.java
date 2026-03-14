class Solution {
    int cnt = 0;
    String res;
    // TC: O(3^n), SC: O(n)
    // Backtracking to generate all happy strings in lexicographical order and count until we reach the k-th one.
    // We can optimize this by calculating the number of happy strings of length n and directly determining the k-th string without generating all of them, but the backtracking approach is straightforward and works well for small n.
    public void buildString(int n, int k, StringBuilder sb) {
        if (sb.length() == n) {
            cnt++;

            if (cnt == k) {
                res = sb.toString();
                return;
            }
        }

        int sbLen = sb.length();

        if (sb.length() < n && cnt < k) {
            for (char ch = 'a'; ch <= 'c'; ch++) {
                if (sbLen == 0 || sb.charAt(sb.length() - 1) != ch) {
                    sb.append(ch);
                    buildString(n, k, sb);
                    sb.deleteCharAt(sbLen);
                }
            }
        }
    }

    public String getHappyString(int n, int k) {
        buildString(n, k, new StringBuilder());
        if (cnt < k) {
            return "";
        }
        return res;
    }
}