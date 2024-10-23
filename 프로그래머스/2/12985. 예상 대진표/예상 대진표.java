class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b){
            if((a+1)/2 == (b+1)/2){
                answer++;
                return answer;
            }
            else{
                a = (a+1) / 2;
                b = (b+1) / 2;
                answer++;
            }
        }

        return answer;
    }
}