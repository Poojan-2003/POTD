class Solution {
    // TC - O(M*N*(M+N)) where M and N are the number of rows and columns in the
    // matrix respectively. We need to iterate through the matrix and for each 1, we
    // need to check its row and column.
    // SC - O(1) as we are using only a constant amount of extra space to store the
    // count of special positions.
    public int numSpecial(int[][] mat) {
        int cnt = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    boolean flag = true;
                    for (int k = 0; k < mat[0].length; k++) {
                        if (mat[i][k] != 0 && k != j) {
                            flag = false;
                            break;
                        }
                    }
                    for (int k = 0; k < mat.length; k++) {
                        if (mat[k][j] != 0 && k != i) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag)
                        cnt++;
                }
            }
        }
        return cnt;
    }
}