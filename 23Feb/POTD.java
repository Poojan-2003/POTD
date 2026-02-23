import java.util.HashSet;

class Solution {

    // TC - O(N*K)
    // SC - O(2^K * K)Each String of length K is stored in the HashSet and there are 2^K such possible combinations of binary strings of length K.
    public boolean hasAllCodes(String s, int k) {
        HashSet<String>hs = new HashSet<>();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        //O(N*K)
        while( j<s.length() ){
            sb.append(s.charAt(j));

            while(sb.length()>k){
                sb = new StringBuilder(sb.substring(i+1)); //O(K)
            }

            if(sb.length() == k && !hs.contains(sb.toString()))hs.add(sb.toString());

            j++;
        }

        return hs.size() == (int)Math.pow(2,k) ? true : false;
    }
}