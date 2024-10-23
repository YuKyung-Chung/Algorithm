class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int round = 0;
        int[] scores = new int[4];
        String now = "";
        for(int i=0; i<dartResult.length(); i++){
            if(dartResult.substring(i,i+1).equals("S")){
                round++;
                scores[round] += Math.pow(Integer.parseInt(now), 1);
                now="";
            }
            else if(dartResult.substring(i,i+1).equals("D")){
                round++;
                scores[round] += Math.pow(Integer.parseInt(now), 2);
                now="";
            }
            else if(dartResult.substring(i,i+1).equals("T")){
                round++;
                scores[round] += Math.pow(Integer.parseInt(now), 3);
                now="";
            }
            else if(dartResult.substring(i,i+1).equals("*")){
                scores[round] *= 2;
                scores[round-1] *= 2;
            }
            else if(dartResult.substring(i,i+1).equals("#")){
                scores[round] *= (-1);
            }
            else{
                now += dartResult.substring(i,i+1);
            }
        }
        
        for(int i:scores){
            answer += i;
        }
        
        return answer;
    }
}