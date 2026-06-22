class Solution {
    int dp[][];
    public int calculateMinimumHP(int[][] dungeon) {
        dp = new int[dungeon.length][dungeon[0].length];
        for(int a[] : dp) Arrays.fill(a, Integer.MIN_VALUE);

        int res = solve(0,0, dungeon);
        return Math.abs(res)+1;
    }

    private int solve(int i, int j, int arr[][]) {
        if(i >= arr.length || j >= arr[0].length) return (int)(-1e7);
        if(i == arr.length-1 && j == arr[0].length-1) {
            return Math.min(0, arr[i][j]);
        }

        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int goRight = solve(i,j+1, arr);
        int goDown = solve(i+1, j, arr);
        if(goRight == 0 || goDown == 0) {
            return dp[i][j] = Math.min(0, arr[i][j]);
        }
        return dp[i][j] = Math.min(Math.max(goRight, goDown) + arr[i][j], 0);
    }
}
