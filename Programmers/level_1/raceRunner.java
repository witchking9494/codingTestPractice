// 완주하지 못한 선수
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        // 참가자의 이름과 출현 횟수를 저장할 HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        
        // 동명이인 존재할 수 있으므로 'map.getOrDefault(person, 0) +1'를 value값으로
        for(String person : participant) {
            map.put(person, map.getOrDefault(person, 0) +1 );
        }
        
        // 완주자 명단에 존재한다면 value값을 0으로 처리
        for (String person : completion) {
            map.put(person, map.get(person) -1);
        }
        
        // value 값이 0 이상인 key값을 return
        for (String person : map.keySet()){
            if(map.get(person) > 0) {
                answer = person;
            }
        }
        
        return answer;

        
    }
}