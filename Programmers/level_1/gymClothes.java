// 탐욕법(Greedy) 체육복
// https://school.programmers.co.kr/learn/courses/30/lessons/42862

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // lost를 ArrayList로 변환
        ArrayList<Integer> lostList = new ArrayList<>();
        for (int num : lost) {
            lostList.add(num);
        }
        
        // 본인 여벌 착용하는 경우
        for (int i = 0; i < reserve.length; i++) {
            if (lostList.contains(reserve[i])) {
                lostList.remove(Integer.valueOf(reserve[i]));
                reserve[i] = -1;  // 본인은 제외하므로 여벌 목록에서 -1로 처리
            }
        }
        
        // 재정렬
        Collections.sort(lostList);
        Arrays.sort(reserve);
                
        // 빌려주는 경우
        for(int res : reserve){
            // 본인은 제외하고 진행
            if (res == -1) continue;
            // 앞번호 // 뒷번호 //
            if(lostList.contains(Integer.valueOf(res-1))){
                lostList.remove(Integer.valueOf(res-1));
            } else if(lostList.contains(Integer.valueOf(res+1))){
                lostList.remove(Integer.valueOf(res+1));
            }        
        }
        
        // 총 인원 - 여벌 못 받은 도난 학생 수
        int answer = n - lostList.size();
        return answer;
    }
}