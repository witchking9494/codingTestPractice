// 2018 KAKAO BLIND RECRUITMENT [1차] 뉴스 클러스터링
// https://school.programmers.co.kr/learn/courses/30/lessons/17677

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        int answer = 0;
        int intersection = 0;   // 교집합
        int union = 0;          // 합집합
        
        
        // 다중집합 ArrayList
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        
        
        // 영단어 소문자로 변환
        // 영문자로 된 글자 쌍만 유효
        for(int i=0; i<str1.length()-1; i++){
            String pair1 = str1.toLowerCase().substring(i, i+2);
            if (pair1.matches("[a-z][a-z]")){
                list1.add(pair1);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            String pair2 = str2.toLowerCase().substring(i, i+2);
            if (pair2.matches("[a-z][a-z]")){
               list2.add(pair2);
            }
        }
        
        
        // 교집합 (중복 고려)
        ArrayList<String> list2Copy = new ArrayList<>(list2);
        for (String pair : list1) {
            if (list2Copy.contains(pair)) {
                intersection++;
                list2Copy.remove(pair);  // 중복 제거
            }
        }                
        
        // 합집합
        union = list1.size() + list2.size() - intersection;
        
        // 만약 두 리스트가 모두 비어 있으면, 자카드 유사도는 1로 설정
        if (list1.isEmpty() && list2.isEmpty()) {
            return 65536; 
        }

        // 자카드 유사도(교집합/합집합) * 65536 한 다음에 소수점 아래 버리기
        answer = (int) Math.floor((intersection / (double) union) * 65536);
        
        return answer;
    }
}