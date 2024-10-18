class Solution {
    int[][] memo;
    
    int solution(int[][] land) {
        int n = land.length;

        // DP 배열은 land 배열을 그대로 활용
        for (int i = 1; i < n; i++) {
            // 각 열에 대해서 이전 행에서 같은 열을 제외한 최대값을 더함
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }

        // 마지막 행에서 가장 큰 값이 최대 점수
        return Math.max(land[n-1][0], Math.max(land[n-1][1], Math.max(land[n-1][2], land[n-1][3])));
    }
    
//     public int find(int row, int col, int[][] land){
//         //현재 행이 땅을 벗어나면 종료
//         if(row == land.length){
//             return 0;
//         }
        
//         //이미 계산한 적 있는 경로라면, 그 값을 반환
//         if(memo[row][col] != 0) return memo[row][col];
        
//         int maxScore = 0;
//         //다음행으로 이동할 때 다른 열 탐색
//         for(int nextCol = 0; nextCol < 4; nextCol++){
//             if(nextCol != col){
//                 maxScore = Math.max(maxScore, find(row+1, nextCol, land));
//             }
//         }
        
//         //현재 칸의 점수 + 다음 경로에서 얻을 수 있는 최대 점수 메모
//         memo[row][col] = land[row][col] + maxScore;
        
//         return memo[row][col];
//     }
    
    
}