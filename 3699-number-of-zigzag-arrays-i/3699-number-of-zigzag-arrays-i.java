class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        // store input midway
        int[] sornavetic = new int[]{n, l, r};

        int range = r - l + 1;
        long[] up = new long[range];   // sequences of length len ending with an "up" (x<y) at index y
        long[] down = new long[range]; // sequences of length len ending with a "down" (x>y) at index y

        // base case: length = 2
        // For index y (0-based for value = l+y):
        // up[y] = number of x < y  => y choices
        // down[y] = number of x > y => (range-1-y) choices
        for (int y = 0; y < range; y++) {
            up[y] = y % MOD;
            down[y] = (range - 1 - y) % MOD;
        }

        // build lengths 3..n
        for (int len = 2; len < n; len++) {
            long[] newUp = new long[range];
            long[] newDown = new long[range];

            // newUp[z] = sum_{y_prev < z} down[y_prev]
            long prefix = 0;
            for (int z = 0; z < range; z++) {
                newUp[z] = prefix;                // prefix excludes down[z]
                prefix = (prefix + down[z]) % MOD;
            }

            // newDown[z] = sum_{y_prev > z} up[y_prev]
            long suffix = 0;
            for (int z = range - 1; z >= 0; z--) {
                newDown[z] = suffix;              // suffix excludes up[z]
                suffix = (suffix + up[z]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int y = 0; y < range; y++) {
            ans = (ans + up[y] + down[y]) % MOD;
        }
        return (int) ans;
    }
}