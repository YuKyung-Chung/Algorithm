import java.util.*;

public class Solution {
    public int solution(int n) {
        int batteryUsuage = 0; //건전지 사용량
        
        while(n > 0){
            if(n % 2 == 0){
                n = n/2; //순간이동
            }
            else{
                n = n-1; //건전지 사용
                batteryUsuage++;
            }
        }
        return batteryUsuage;
    }
}