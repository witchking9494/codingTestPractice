// K번째수
// https://school.programmers.co.kr/learn/courses/30/lessons/42748

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        // commands의 길이만큼 반복
        for(int a=0; a<commands.length; a++){
                        
            // i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수
            int i = commands[a][0]-1;
            int j = commands[a][1];
            int k = commands[a][2]-1;
            
            // 복사된 원본 잘라낸 이후 정렬
            int[] copy =  Arrays.copyOfRange(array, i, j);
            Arrays.sort(copy);
            
            // k번째에 있는 수
            answer[a] = copy[k];
        }
        
        return answer;
    }
}