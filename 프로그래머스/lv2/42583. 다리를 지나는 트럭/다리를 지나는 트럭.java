import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();// 큐 선언
        int sum = 0;
        int time = 0;
        for(int i=0; i<truck_weights.length; i++){
            int truck = truck_weights[i];
            
            while(true){
                if(q.isEmpty()){ //큐가 비어있으면
                    q.add(truck); //트럭 지나가도록 큐에 추가
                    sum += truck; //합에 추가
                    time++; //시간 증가
                    break;
                }
                //다리 위에 트럭이 꽉 차있으면
                if(q.size() == bridge_length){
                    //트럭을 큐에서 빼주고 합에서도 빼줌
                    sum -= q.poll();
                }
                //기존 다리에 올라가 있는 트럭과 새로 들어온 트럭이 합이 
                if(sum + truck <= weight){
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                
                    q.add(0);
                    time++;
                }
        }
        return time + bridge_length;
    }
}