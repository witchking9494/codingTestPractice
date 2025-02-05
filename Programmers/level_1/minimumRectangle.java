// 완전탐색 최소직사각형
// https://school.programmers.co.kr/learn/courses/30/lessons/86491

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        // 가로 길이가 세로 길이보다 길다고 가정
        int maxNum = 0; // 가로
        int minNum = 0; // 세로
        // int max1 = 0;
        // int max2 = 0;
        
        for(int i=0; i<sizes.length; i++){
            
            // max와 min을 이용하여, 가로와 세로의 최댓값 구하기
            int tempMax = Math.max(sizes[i][0], sizes[i][1]);
            int tempMin = Math.min(sizes[i][0], sizes[i][1]);
            if(maxNum < tempMax) maxNum = tempMax;
            if(minNum < tempMin) minNum = tempMin;
            
            // // 각 배열을 오름차순으로 정렬 후, 가로와 세로의 최댓값 구하기
            // Arrays.sort(sizes[i]);
            // if(sizes[i][0] > max1) max1 = sizes[i][0];
            // if(sizes[i][1] > max2) max2 = sizes[i][1];
        }

        int answer = maxNum * minNum;
        // int answer = max1 * max2;
        return answer;
    }
}