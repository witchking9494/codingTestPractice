// 추억 점수
// https://school.programmers.co.kr/learn/courses/30/lessons/176963

import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int score = 0;
        int[] result = new int[photo.length];
        
        // 그리워하는 사람의 이름을 담은 문자열 배열 name
        // 각 사람별 그리움 점수를 담은 정수 배열 yearning
        // 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo
        
        // name과 yearning에 담긴 값을 HashMap 이용해서 매핑.
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
                map.put(name[i], yearning[i]);
        }
        
        // photo의 행만큼 반복
        for (int i = 0; i < photo.length; i++) {
            // photo i행의 길이만큼 반복
            // 사진에 찍힌 인물의 이름이 name에 없을 경우를 대비하여 get 대신 getOrDefault 사용
            for (int j = 0; j < photo[i].length; j++) {
                score += map.getOrDefault(photo[i][j], 0);
            }
            // result에 score값 넣어준 뒤 초기화
            result[i] = score;
            score = 0;
        }
        
        return result;
    }
}