class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = 0;
        int[] arr = new int[n+2];
        for(int l:lost){
            arr[l]++;
        }
        for(int r:reserve){
            arr[r]--;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                if(arr[i-1] == 1){
                    arr[i]++;
                    arr[i-1]--;
                } else if(arr[i+1] == 1){
                    arr[i]++;
                    arr[i+1]--;
                }
            }
        }
        for(int i:arr){
            if(i == 1){
                count++;
            }
        }
        answer = n-count;
        return answer;
    }
}