// 푸드 파이트 대회
// https://school.programmers.co.kr/learn/courses/30/lessons/134240

import java.util.ArrayList;

class Solution {
    public String solution(int[] food) {
        
        // food[0]은 수웅이가 준비한 물의 양이며, 항상 1
        // food[i]는 i번 음식의 수
        
        // 음식의 수는 2 이상이어야 함
        // 음식의 수를 2로 나누었을 때, 그에 해당하는 몫만큼 양쪽에 각각 기입
        // 몫과 인덱스 값을 기억해야 함. 
        
        ArrayList<Integer> foodAmount = new ArrayList<>();  // 음식 갯수
        ArrayList<Integer> foodName = new ArrayList<>();    // 음식 이름
        
        for (int i=1; i < food.length; i++) {
            if (food[i]/2 >= 1) {
                foodAmount.add(food[i]/2);
                foodName.add(i);
            }
        }
        
        // 음식 수만큼 result 양쪽에 적히도록
        // 표기는 해당 음식의 인덱스 값으로
        StringBuilder strBuilder = new StringBuilder(" ");        
        
        for (int i=foodAmount.size()-1; i >= 0; i--) {
            int amout = foodAmount.get(i);
            String name = Integer.toString(foodName.get(i));
            for (int j=0; j < amout; j++){
                strBuilder.insert(strBuilder.length() - 1, name);
                strBuilder.insert(0, name);
            }
        }
        
        // 가운데에 0 추가
        int middleIndex = strBuilder.length() / 2;
        strBuilder.insert(middleIndex, "0");
        strBuilder.delete(strBuilder.length() - 1, strBuilder.length());
        
        String answer = strBuilder.toString();
        return answer;
    }
}