class Solution {
    final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        // 5원
        // 1원 5개
        // 1원 3개, 2원 1개 
        // 1원 1개, 2원 2개 
        // 5원 1개
        // 순서 상관없이 
        // dp[5]: 5원을 만드는 경우의 수 
       
        int[] dp = new int[n + 1];
        dp[0] =  1;
        
        // 1, 2, 5
        // n원까지 coin원을 사용해서 만들 수 있는 경우의 수를 누적한다. 
        for (int coin: money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD; 
            }
        }
        
        return dp[n];
    }
}