// 2018 KAKAO BLIND RECRUITMENT [1차] 캐시
// https://school.programmers.co.kr/learn/courses/30/lessons/17680

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        int answer = 0;
        
        // cacheSize가 0인 경우, 빠르게 처리        
        if(cacheSize == 0) {
            answer = cities.length*5;
            return answer;
        }
                
        // accessOrder=true로 설정하여 접근 순서대로 항목을 저장
        // 초기 용량은 cacheSize으로 설정
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>(cacheSize, 0.75f, true);
        
        
        for (int i = 0; i < cities.length; i++) {
            // cities의 단어들 소문자로 처리
            cities[i] = cities[i].toLowerCase();            
            // cache hit (실행시간 1) // cache miss (실행시간 5) //
            if((map.get(cities[i])) != null) {      
                answer += 1;
            } else {                                
                answer += 5;
                map.put(cities[i], 1);
            }            
            // cacheSize 초과할 경우, 마지막으로 검색한 도시 제거
            if (map.size() > cacheSize) {           
                String firstKey = map.keySet().iterator().next();
                map.remove(firstKey);
            }                        
        }
        
        return answer;
    }
}