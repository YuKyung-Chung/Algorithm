class Solution {
    static int[] board;
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        board = new int[n];
        
        DFS(0, n);
        return answer;
    }
    
    public static void DFS(int row, int n){
        if(row == n){
            answer++;
            return;
        }
        
        //현재 행에 퀸을 각 열에 배치해보고 유효성 체크
        for(int col=0; col<n; col++){
            if(isSafe(row, col)){
                board[row] = col; //현재 행의 해당 열에 퀸 배치
                DFS(row+1, n); //다음 행으로 재귀 호출
            }
        }
    }
    
    //퀸이 같은 열 또는 대각선에 있는지 확인하는 함수
    public static boolean isSafe(int row, int col){
        for(int i=0; i<row; i++){
            //같은 열에 퀸이 있는지 확인
            if(board[i] == col)
                return false;
            
            //대각선에 퀸이 있는지 확인
            if(Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        }
        return true;
    }
}