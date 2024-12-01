// 같은 숫자는 싫어
// https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        // 연속되는 숫자가 아닌 값들을 저장할 ArrayList 생성
        List<Integer> list = new ArrayList<>();
        
        // 첫 번째 요소는 무조건 추가
        if (arr.length > 0) {
            list.add(arr[0]);
        }
        
        // 연속되는 숫자가 아닌 경우만 추가
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        // ArrayList를 int[] 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
