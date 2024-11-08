class Solution {
    public int solution(int n, int[] money) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        
        dp[0] = 1; // 금액 0을 만드는 방법은 1가지

        //각 화폐 단위별로 dp 갱신
        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }

        return dp[n];
    }
}