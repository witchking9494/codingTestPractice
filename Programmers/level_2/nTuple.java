// 2019 카카오 개발자 겨울 인턴십 튜플
// https://school.programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // s에 담긴 중괄호 제거 후, 숫자들을 쉼표로 구분
        s = s.replaceAll("[{}]", "");
        String[] numbers = s.split(",");
        
                
        // 중복 횟수를 저장할 Map
        Map<String, Integer> map = new HashMap<>();


        // 배열을 순회하며 각 숫자의 등장 횟수 세기
        for (String number : numbers) {
            // 이미 등장한 숫자가 있다면 값 증가, 없으면 1
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        
        // key와 value를 저장할 List 생성
        List<String> keys = new ArrayList<>(map.keySet());
        
        // value값 기준으로 key값을 내림차순 정렬
        for (int i = 0; i < keys.size(); i++) {
            for (int j = i + 1; j < keys.size(); j++) {
                if (map.get(keys.get(i)) < map.get(keys.get(j))) {
                    String temp = keys.get(i);
                    keys.set(i, keys.get(j));
                    keys.set(j, temp);
                }
            }
        }

        // 정렬된 key값을 answer 배열에 담기
        int[] answer = new int[map.size()];
        for (int i = 0; i < keys.size(); i++) {
            answer[i] = Integer.parseInt(keys.get(i));  // key를 int로 변환
        }               
                
        return answer;
    }
}