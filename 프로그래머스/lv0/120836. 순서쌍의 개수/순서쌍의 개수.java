import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> num = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            if(n % i == 0){
                num.add(i);
            }
        }
        
        for(int i:num){
            for(int j=1; j<=n; j++){
                if(i * j == n){
                    answer++;
                }
            }
        }
        return answer;
    }
}