// 힙(Heap) 더 맵게
// https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=java

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // PriorityQueue에 값 추가
        for (int sco : scoville) {
            pq.add(sco);
        }
        
        // 반복문으로 두 개의 값을 꺼내어 섞기
        while (pq.size() > 1 && pq.peek() < K) {
            int one = pq.poll();  // 가장 작은 값
            int two = pq.poll();  // 두 번째로 작은 값
            
            // 새로운 스코빌 지수 계산
            int newSco = one + (two * 2);
            pq.add(newSco);  // 새로운 스코빌 지수를 큐에 추가
            
            // 섞은 횟수 증가
            answer++;
        }
        
        // 모든 음식의 스코빌 지수가 K 이상이면 answer 반환
        // 그렇지 않으면 -1을 반환
        if (pq.peek() >= K) {
            return answer;
        }
        
        return -1;
    }
}
