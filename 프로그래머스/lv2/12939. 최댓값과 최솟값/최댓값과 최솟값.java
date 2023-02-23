class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int[] number = new int[str.length];

        for(int i=0; i<str.length; i++){
            number[i] = Integer.parseInt(str[i]);
        }
        int min = number[0];
        int max = number[0];
        for(int i=0; i<number.length; i++){
            min = Math.min(min,number[i]);
            max = Math.max(max,number[i]);
        }
        answer = min + " " + max;
        return answer;
    }
}