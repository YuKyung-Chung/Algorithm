class Solution {
    public int solution(int n) {
        int answer = 0;
        int curOne = toBinary(n);
        
        while(true){
            int nextOne = toBinary(++n);
            if(nextOne == curOne) break;
        }
        answer = n;
        return answer;
    }
    public static int toBinary(int a){
        int one = 1;
        while(a>1){
            if(a%2 == 1){
                one++;
            }
            a = a/2;
        }
        return one;
    }
}