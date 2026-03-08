import java.util.HashSet;

class Solution {
    // TC - O(N * 2^N) where N is the length of the input array nums. We need to iterate through the input array once to add all the elements to the hash set, which takes O(N) time. Then, we need to iterate through all possible binary strings of length N, which takes O(2^N) time. For each binary string, we check if it is present in the hash set, which takes O(1) time on average. Therefore, the overall time complexity is O(N * 2^N).
    // SC - O(N) as we are using a hash set to store the unique binary strings from the input array, which can take up to O(N) space in the worst case when all binary strings in the input array are unique.
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> s = new HashSet<>();
        for (String num : nums) {
            s.add(num);
        }
        int n = s.size();
        for (int i = 0; i < (1 << n); i++) {
            String bin = Integer.toBinaryString(i);
            // fix: add leading zeros
            while (bin.length() < n) {
                bin = "0" + bin;
            }
            if (!s.contains(bin)) {
                return bin;
            }
        }
        return "";
    }
}