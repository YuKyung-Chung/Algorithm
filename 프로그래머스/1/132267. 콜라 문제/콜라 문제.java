class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a){
            int now = n / a * b;
            answer += now;

            n = n % a + now;
        }
        
        
        
        return answer;
    }
}