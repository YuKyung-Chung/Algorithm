import java.util.*;
import java.io.*;

class Solution {
    public class Cars implements Comparable<Cars> {
        String timestamp;
        int carNo;
        String state;

        public Cars(String timestamp, int carNo, String state) {
            this.timestamp = timestamp;
            this.carNo = carNo;
            this.state = state;
        }

        // 차량번호 작은 자동차순으로 정렬
        @Override
        public int compareTo(Cars car) {
            return this.carNo - car.carNo;
        }
    }

    static int basicTime, basicFee, unitTime, unitFee = 0;
    public int[] solution(int[] fees, String[] records) {
        List<Cars> carList = new ArrayList<>();
        
        basicTime = fees[0]; // 기본시간
        basicFee = fees[1]; // 기본요금
        unitTime = fees[2]; // 단위시간
        unitFee = fees[3]; // 단위요금
        
        for (String str : records) {
            String timestamp = str.split(" ")[0]; // 시각
            int carNo = Integer.parseInt(str.split(" ")[1]); // 차량번호
            String state = str.split(" ")[2]; // 내역
            Cars car = new Cars(timestamp, carNo, state);
            carList.add(car);
        }
        
        Collections.sort(carList); // 차량번호 순으로 정렬

        // 요금 계산을 위한 해시맵
        Map<Integer, Integer> totalTimeMap = new HashMap<>();
        Map<Integer, String> lastInTimeMap = new HashMap<>();

        for (Cars car : carList) {
            int carNo = car.carNo;
            String timestamp = car.timestamp;
            String state = car.state;

            if (state.equals("IN")) {
                lastInTimeMap.put(carNo, timestamp);
            } else {
                String inTime = lastInTimeMap.remove(carNo);
                int parkedMinutes = calculateMinutes(inTime, timestamp);
                totalTimeMap.put(carNo, totalTimeMap.getOrDefault(carNo, 0) + parkedMinutes);
            }
        }

        // 출차 기록이 없는 차량 처리
        for (Map.Entry<Integer, String> entry : lastInTimeMap.entrySet()) {
            int carNo = entry.getKey();
            String inTime = entry.getValue();
            int parkedMinutes = calculateMinutes(inTime, "23:59");
            totalTimeMap.put(carNo, totalTimeMap.getOrDefault(carNo, 0) + parkedMinutes);
        }

        // 차량별 요금 계산 및 결과 저장
        List<Integer> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);
        List<Integer> answer = new ArrayList<>();
        for (int carNo : carNumbers) {
            int totalMinutes = totalTimeMap.get(carNo);
            int fee = calculateFee(totalMinutes);
            answer.add(fee);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    // 주차요금 구하는 메서드
    private int calculateFee(int sumTime) {
        if (sumTime <= basicTime) {
            return basicFee;
        } else {
            return basicFee + (int) Math.ceil((sumTime - basicTime) / (double) unitTime) * unitFee;
        }
    }

    // 총 시간(분) 구하는 메서드
    private int calculateMinutes(String start, String end) {
        String[] startSplit = start.split(":");
        String[] endSplit = end.split(":");
        int startMinutes = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
        int endMinutes = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);
        return endMinutes - startMinutes;
    }
}
