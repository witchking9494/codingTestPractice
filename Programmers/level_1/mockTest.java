// 완전탐색 모의고사
// https://school.programmers.co.kr/learn/courses/30/lessons/42840

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        // 수포자 패턴
        int[] pat1 = {1, 2, 3, 4, 5};
        int[] pat2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pat3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 수포자 맞춘 문제 개수
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == pat1[i % pat1.length]) ans1++;
            if(answers[i] == pat2[i % pat2.length]) ans2++;
            if(answers[i] == pat3[i % pat3.length]) ans3++;
        }
        
        // 가장 많이 맞춘 수포자 점수
        int max = Math.max(ans1, Math.max(ans2, ans3));

        // ArrayList에 담은 이후, int[]로 변환
        ArrayList<Integer> result = new ArrayList<>();
        if (ans1 == max) result.add(1);
        if (ans2 == max) result.add(2);
        if (ans3 == max) result.add(3);
        
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        
        return array;
    }
}