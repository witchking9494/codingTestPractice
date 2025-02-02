// 정렬 가장 큰 수
// https://school.programmers.co.kr/learn/courses/30/lessons/42746

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 문자열 배열로 치환
        String[] strNumbers = new String[numbers.length];
        for (int i=0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // 순서 재배치
        // Arrays.sort()는 재귀적 정렬을 사용하기 때문에 
        // 배열의 요소들 간에 compareTo()를 반복적으로 호출하여 정렬을 수행
        Arrays.sort(strNumbers, (a,b) -> (b+a).compareTo(a+b));
        
        // 정렬된 배열을 문자로
        StringBuilder sb = new StringBuilder();
        for (String str : strNumbers) {
            sb.append(str);
        }

        // 0만 있는 경우 별도 처리
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}