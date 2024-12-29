// 폰켓몬
// https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;

class Solution {
    public int solution(int[] nums) {
       
        // HashSet 선언
        HashSet<Integer> set = new HashSet<>();
        
        // nums 안에 담긴 값들 HashSet에 넣기
        for(int num : nums) {
            set.add(num);
        }
        
        // 선택할 수 있는 폰켓몬의 수는 nums.length / 2
        int num = nums.length / 2;
        
        // 선택할 수 있는 폰켓몬의 종류는 set.size()로 결정
        int size = set.size();
        
        // 폰켓몬을 선택할 수 있는 경우의 수 계산 
        int answer = Math.min(num, size);
        
        return answer;
    }
    
}

