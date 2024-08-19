import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> map = new HashMap<>(); //주고받은 선물
        for(int i=0; i<friends.length; i++){
            map.put(friends[i], i);
        }
        
        //선물 지수 저장할 배열
        int[] giftIndex = new int[friends.length];
        //주고 받은 선물 정보 저장할 배열
        int[][] list = new int[friends.length][friends.length];
        
        for(String str: gifts){
            String giver = str.split(" ")[0];
            String receiver = str.split(" ")[1];
            
            //선물 지수 증가
            giftIndex[map.get(giver)]++;
            //선물 지수 감소
            giftIndex[map.get(receiver)]--;
            // 선물 주고받은 횟수 저장
            list[map.get(giver)][map.get(receiver)]++;
        }
        
        //가장 선물 많이 받는 개수 저장
        int answer = 0;
        
        for(int i=0; i<friends.length; i++){
            int cnt = 0;
            
            for(int j=0; j<friends.length; j++){
                if(i == j) continue;
                
                //선물 많이 준 사람이 선물 받음
                if(list[i][j] > list[j][i]){
                    cnt++;
                }
                //주고받은 기록 없거나 같은 경우
                //선물 지수 높은 사람이 선물 받음
                else if(list[i][j] == list[j][i] && giftIndex[i] > giftIndex[j]) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    
    
}