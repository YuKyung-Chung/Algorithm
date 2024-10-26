class Solution {
    //투 포인터로 풀기
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = sequence[0];
        
        //길이가 짧은 수열 찾기
        while(j < sequence.length){
            if(sum == k){
                int length = j-i+1;
                if(length < minLen){
                    minLen = length;
                    answer[0] = i;
                    answer[1] = j;
                }
                sum -= sequence[i];
                i++; //i 포인터 이동해서 더 짧은 부분 수열 찾도록 함
            }
            else if(sum < k){
                j++;
                if(j < sequence.length){
                    sum += sequence[j];
                }
            }
            else {
                sum -= sequence[i];
                i++; //i 포인터 이동해서 더 짧은 부분 수열 찾도록 함
            }
        }
        
        return answer;
    }
}