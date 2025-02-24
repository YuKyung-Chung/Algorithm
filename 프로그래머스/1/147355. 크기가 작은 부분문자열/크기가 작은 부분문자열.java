class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        for(int i=0; i<=t.length()-len; i++){
            if(t.substring(i,i+len).compareTo(p) <= 0){
                answer++;
            }
        }
        return answer;
    }
}