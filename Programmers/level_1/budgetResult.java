// Summer/Winter Coding(~2018) 예산
// https://school.programmers.co.kr/learn/courses/30/lessons/12982

import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        
        int answer = 0;
        
        // d를 오름차순으로 sort
        Arrays.sort(d);
        
        // budget에서 순차적으로 뺄셈
        // 뺄셈 했는데 0미만일 경우, skip하고 다음 숫자
        for(int i=0; i<d.length; i++){
            if(budget - d[i] < 0) {
                continue;
            } else {
                budget -= d[i];
                answer++;
            }                   
        }        
                        
        return answer;
    }
}