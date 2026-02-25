import java.util.ArrayList;
import java.util.Arrays;

public class POTD {
    class Solution {
        public static int setBit(int num) {
            int res = 0;

            while (num != 0) {
                res += (num & 1) == 1 ? 1 : 0;
                num >>= 1;
            }
            return res;
        }

        public int[] sortByBits(int[] arr) {
            Arrays.sort(arr);
            ArrayList<ArrayList<Integer>> al = new ArrayList<>();
            int ans[] = new int[arr.length];
            int k = 0;
            for (int i = 0; i < 33; i++) {
                al.add(new ArrayList<>());
            }
            for (int num : arr) {
                int setBit = setBit(num);
                al.get(setBit).add(num);
            }
            for (int i = 0; i < al.size(); i++) {
                for (int j = 0; j < al.get(i).size(); j++) {
                    ans[k] = al.get(i).get(j);
                    k++;
                }
            }
            return ans;
        }
    }
}
