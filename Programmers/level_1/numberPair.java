// 숫자 짝꿍
// https://school.programmers.co.kr/learn/courses/30/lessons/131128

import java.util.Map;
import java.util.HashMap;
// import java.util.List;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;

class Solution {
    public String solution(String X, String Y) {
        
        StringBuilder answer = new StringBuilder();
        
        // 각 숫자의 개수를 기록할 hashmap
        Map<Character, Integer> hashmapX = new HashMap<>();
        Map<Character, Integer> hashmapY = new HashMap<>();        
         
        for (char c : X.toCharArray()) {
            hashmapX.put(c, hashmapX.getOrDefault(c, 0) + 1);
        }
        for (char c : Y.toCharArray()) {
            hashmapY.put(c, hashmapY.getOrDefault(c, 0) + 1);
        }        
        
        
//         // 성능 문제로 인해 개선 필요 (연산 속도 너무 오래 걸림)
//         // 공통 문자를 찾고 빈도수만큼 ArrayList에 담음
//         List<Character> commonNum = new ArrayList<>();
//         for (char c : hashmapX.keySet()) {  
//             if (hashmapY.containsKey(c)) {  // X에 담긴 숫자가 Y에도 있는 경우
//                 int count = Math.min(hashmapX.get(c), hashmapY.get(c));   // 공통 숫자 갯수 확인
//                 for (int i = 0; i < count; i++) {
//                     commonNum.add(c);   // 갯수만큼 commonNum에 넣어줌
//                 }
//             }
//         }        
//         // 공통 숫자 담긴 ArrayList를 내림차순으로 정렬
//         Collections.sort(commonNum, Comparator.reverseOrder());
//         for (char s : commonNum) {
//             answer += s;
//         }
        
        
        // 공통 숫자의 최대 빈도수를 구하여 해당 숫자만큼 결과에 추가
        for (char c = '9'; c >= '0'; c--) {                                     // '9'부터 '0'까지 내림차순으로 확인
            if (hashmapX.containsKey(c) && hashmapY.containsKey(c)) {           // 공통된 숫자 존재하는 경우
                int commonCount = Math.min(hashmapX.get(c), hashmapY.get(c));   // 공통된 숫자의 갯수 확인
                for (int i = 0; i < commonCount; i++) {                         // 해당 숫자를 추가
                    answer.append(c);
                }
            }
        }
        
                
        // X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1
        // X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0
        if (answer.length() == 0) {
            return "-1";
        }
        if (answer.charAt(0) == '0') {
            return "0";
        }   
        
        
        // StringBuilder에서 String으로 변환
        return answer.toString();  
    }
}