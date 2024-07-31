import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 두 큐의 합을 계산
        long sum1 = 0, sum2 = 0;
        for (int num : queue1) sum1 += num;
        for (int num : queue2) sum2 += num;

        // 두 큐의 합이 홀수라면, 합을 같게 만들 수 없음
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        long target = (sum1 + sum2) / 2;

        // 두 큐를 하나로 합친 배열로 처리
        int n = queue1.length;
        int[] mergedQueue = new int[2 * n];
        System.arraycopy(queue1, 0, mergedQueue, 0, n);
        System.arraycopy(queue2, 0, mergedQueue, n, n);

        // 투 포인터 초기화
        int left = 0, right = n;
        long currentSum = sum1;
        int operations = 0;

        // 슬라이딩 윈도우를 이용한 투 포인터 방식
        while (left < 2 * n && right < 2 * n) {
            if (currentSum == target) return operations;
            if (currentSum < target) {
                currentSum += mergedQueue[right++];
            } else {
                currentSum -= mergedQueue[left++];
            }
            operations++;
        }
        
        return -1;
    }
}