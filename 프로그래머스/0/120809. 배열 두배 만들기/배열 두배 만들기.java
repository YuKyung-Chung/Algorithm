class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int n = 0;
        for(int i : numbers){
            answer[n] = numbers[n] * 2;
            n++;
        }
        return answer;
    }
}