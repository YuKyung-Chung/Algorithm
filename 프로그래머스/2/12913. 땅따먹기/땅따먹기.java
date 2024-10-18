class Solution 
{
    int solution(int[][] land) 
    {
        int answer = 0;

        // 각 행의 각 열마다 최대값을 저장해 나간다. 
        int dp[][] = new int[land.length + 1][4];

        // 각 행의 대한 계산
        for(int i = 1; i <= land.length; i++)
        {
            // 각 열에 대한 계산
            for(int j = 0; j < 4; j++)
            {
                // 현재 열을 제외한 나머지 열에 대한 최댓값을 계산한다
                for(int k = 0; k < 4; k++)
                {
                    // 현재 열은 무시
                    if(k == j)
                    {
                        continue;
                    }

                    // 현재 열을 제외한 나머지 열에 대한 계산값을 비교하고 최댓값을 기록한다. 
                    dp[i][j] = Math.max(dp[i][j], land[i - 1][j] + dp[i - 1][k]);

                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer;
    }
}