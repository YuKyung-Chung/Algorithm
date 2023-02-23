import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<String>();
        boolean flag = true;
        
        for(int i=0; i<words.length; i++){
            //똑같은 단어 또 말하면 탈락
            if(list.contains(words[i])){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                flag = false;
                break;
            }
            list.add(words[i]);
            
            //끝말잇기가 성립이 안되면 탈락
            if(i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                flag = false;
                break;
            }
        }
        //탈락자가 생기지 않으면 [0,0] return
        if(flag == true){
            answer[0] = 0;
            answer[1] = 0;
        }        
        return answer;
    }
}