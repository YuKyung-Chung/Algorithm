class Solution {
    boolean solution(String s) {
        int cntp =0;
        int cnty =0;
        if(s.length() == 0){return true;}
        String[] arr = s.toLowerCase().split("");
        
        for(int i=0; i<arr.length;i++){
            if(arr[i].equals("p")){
                cntp++;
            }
            if(arr[i].equals("y")){
                cnty++;
            }
        }
        
        if(cntp==cnty){
            return true;
        } else{
            return false;
        }
        
    }
}