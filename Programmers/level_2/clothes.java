// 의상
// https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // HashMap 생성
        Map<String, Integer> map = new HashMap<>();
        
        // key값 없으면 추가
        // key값 있으면 value++
        for(int i=0; i<clothes.length; i++){
            String category = clothes[i][1]; // 의상 종류
            map.put(category, map.getOrDefault(category, 0) + 1);
        }
        
        // 모든 경우의 수 = 각 경우의 수 모두 곱하기
        // 각 경우의 수 = map.get()+1 (입지 않는다는 선택지 추가)
        // 원활한 곱셉을 위해 answer = 1
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }
        
        // 모두 입지 않는다는 선택지는 제외하기 위해 -1
        return answer-1;
    }
}