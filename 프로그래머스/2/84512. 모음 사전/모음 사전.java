import java.util.*;

class Solution {
    static ArrayList<String> list;
    static String[] words = {"A","E","I","O","U"};
    
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        dfs("",0);
        
        for(int i=0; i<list.size(); i++){
            if(word.equals(list.get(i))){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    private static void dfs(String str, int len){
        list.add(str);
        if(len == 5) return;
        
        for(int i=0; i<5; i++){
            dfs(str+words[i],len+1);
        }
    }
}