class Solution {
    public int solution(String my_string) {
        int answer = 0;
        char[] c = my_string.toCharArray();
        for(char ch: c){
            if(ch - 'A' < 0){
                answer += ch - '0';
            }
        }
        return answer;
    }
}