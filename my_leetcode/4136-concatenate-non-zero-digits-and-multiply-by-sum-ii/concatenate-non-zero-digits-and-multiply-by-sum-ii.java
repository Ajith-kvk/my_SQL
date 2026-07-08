class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // compressed digits
        int[] digit = new int[n];
        int[] pos = new int[n];
        int m = 0;

        // original index -> compressed index
        int[] compIndex = new int[n];
        java.util.Arrays.fill(compIndex, -1);

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                digit[m] = d;
                pos[m] = i;
                compIndex[i] = m;
                m++;
            }
        }

        long[] pow10 = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        long[] prefixValue = new long[m + 1];
        int[] prefixSum = new int[m + 1];

        for (int i = 0; i < m; i++) {
            prefixValue[i + 1] = (prefixValue[i] * 10 + digit[i]) % MOD;
            prefixSum[i + 1] = prefixSum[i] + digit[i];
        }

        int[] next = new int[n];
        int last = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0')
                last = compIndex[i];
            next[i] = last;
        }

        int[] prev = new int[n];
        last = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '0')
                last = compIndex[i];
            prev[i] = last;
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = next[l];
            int right = prev[r];

            if (left == -1 || right == -1 || left > right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left + 1;

            long number = (prefixValue[right + 1]
                    - prefixValue[left] * pow10[len] % MOD + MOD) % MOD;

            long sum = prefixSum[right + 1] - prefixSum[left];

            ans[i] = (int) (number * sum % MOD);
        }

        return ans;
    }
}