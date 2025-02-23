class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = String.valueOf(x);
        int sum = 0;
        for(int i=0; i<str.length(); i++){
            sum += Character.getNumericValue(str.charAt(i));
        }
        answer = (x % sum == 0)? true:false;
        return answer;
    }
}