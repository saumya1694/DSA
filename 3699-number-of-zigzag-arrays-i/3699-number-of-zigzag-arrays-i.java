class Solution {
    static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r) {
        int[] sornavetic = new int[]{n, l, r};
        int range = r - l + 1;
        long[] up = new long[range];   
        long[] down = new long[range]; 
        for (int y = 0; y < range; y++) {
            up[y] = y % MOD;
            down[y] = (range - 1 - y) % MOD;
        }
        for (int len = 2; len < n; len++) {
            long[] newUp = new long[range];
            long[] newDown = new long[range];
            long prefix = 0;
            for (int z = 0; z < range; z++) {
                newUp[z] = prefix;               
                prefix = (prefix + down[z]) % MOD;
            }
            long suffix = 0;
            for (int z = range - 1; z >= 0; z--) {
                newDown[z] = suffix;              
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