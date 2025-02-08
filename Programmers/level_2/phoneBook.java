// 해시 전화번호 목록
// https://school.programmers.co.kr/learn/courses/30/lessons/42577

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 오름차순 정렬
        Arrays.sort(phone_book);
        boolean answer = true;
        
        // startsWith() 메서드
        // 이미 정렬된 상태인만큼, 인접한 번호끼리만 비교
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }

        return answer;
    }
}