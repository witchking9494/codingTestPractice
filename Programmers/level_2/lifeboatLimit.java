// 탐욕법(Greedy) 구명보트
// https://school.programmers.co.kr/learn/courses/30/lessons/42885

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        
        // 구명보트는 한 번에 최대 2명, 무게 제한도 존재
        // people을 정렬한 뒤, 무게 최댓값과 최소값의 합을 limit와 비교
        // 1. 최댓값과 최솟값의 합이 limit 이하인 경우
        // 2. 최댓값과 최솟값의 합이 limit 초과인 경우
        
        // 오름차순으로 정렬
        Arrays.sort(people);
        
        int i = 0;                  // 최솟값 인덱스
        int j = people.length - 1;  // 최댓값 인덱스
        
        while (i < j) {
            // 1번 케이스일 경우, 두 사람을 보트에
            if ((people[i]+people[j]) <= limit) {
                answer++;
                i++;  
                j--;
            // 2번 케이스일 경우, 최댓값 혼자 보트에    
            } else {
                answer++;
                j--;  
            }            
        }
        
        // people.length가 홀수인 경우, 마지막 남은 사람 처리
        if (i == j) {
            answer++;
        }

        return answer;
    }
}