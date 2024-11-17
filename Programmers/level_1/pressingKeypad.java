// 2020 카카오 인턴십 키패드 누르기
// https://school.programmers.co.kr/learn/courses/30/lessons/67256

import java.util.Map;


class Solution {
    public String solution(int[] numbers, String hand) {
        
        String answer = "";
        String temp = "";
        int leftPosition = 10;
        int rightPosition = 10;
        // 맨해튼 거리 공식을 적용하지 않아 코드 너무 길어짐
                
        
        for(int i = 0; i < numbers.length; i++) {
            
            // 1, 4, 7을 입력할 때는 왼손 엄지손가락       
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7) {
                answer += "L";
                leftPosition = numbers[i];
                
            // 3, 6, 9를 입력할 때는 오른손 엄지손가락
            } else if (numbers[i]==3 || numbers[i]==6|| numbers[i]==9) {
                answer += "R";
                rightPosition = numbers[i];
            
            // 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락
            // 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락               
            } else if (numbers[i]==2){
                temp = number2(leftPosition, rightPosition, hand);
                answer += temp;
                if(temp.equals("R")) {
                    rightPosition = numbers[i];
                } else {
                    leftPosition = numbers[i];
                }
            } else if (numbers[i]==5) {
                temp = number5(leftPosition, rightPosition, hand);
                answer += temp;
                if(temp.equals("R")) {
                    rightPosition = numbers[i];
                } else {
                    leftPosition = numbers[i];
                }
            } else if (numbers[i]==8) {
                temp = number8(leftPosition, rightPosition, hand);
                answer += temp;
                if(temp.equals("R")) {
                    rightPosition = numbers[i];
                } else {
                    leftPosition = numbers[i];
                }
            } else if (numbers[i]==0) {
                temp = number0(leftPosition, rightPosition, hand);
                answer += temp;
                if(temp.equals("R")) {
                    rightPosition = numbers[i];
                } else {
                    leftPosition = numbers[i];
                }
            }        
        }
        
        return answer;
    }

        // 누를 번호가 2일때
        public static String number2(int left, int right, String hand) {

            Map<Integer, Integer> scoreMap2 = Map.of(
                2, 0,               // position 2의 점수는 0
                1, 1, 3, 1, 5, 1,   // position 1, 3, 5의 점수는 1
                4, 2, 6, 2, 8, 2,   // position 4, 6, 8의 점수는 2
                7, 3, 9, 3, 0, 3    // position 7, 9, 0의 점수는 3
            );

            int leftScore = scoreMap2.getOrDefault(left, 4);
            int rightScore = scoreMap2.getOrDefault(right, 4);

            String answer = compare(leftScore, rightScore, hand);
            return answer;

        }
      
        // 누를 번호가 5일때
        public static String number5(int left, int right, String hand) {

            Map<Integer, Integer> scoreMap5 = Map.of(
                5, 0,                           // position 5의 점수는 0
                2, 1, 4, 1, 6, 1, 8, 1,         // position 2, 4, 6, 8의 점수는 1
                1, 2, 3, 2, 7, 2, 9, 2, 0, 2    // position 1, 3, 7, 9, 0 의 점수는 2
            );

            int leftScore = scoreMap5.getOrDefault(left, 3);
            int rightScore = scoreMap5.getOrDefault(right, 3);

            String answer = compare(leftScore, rightScore, hand);
            return answer;

        }    
    
        // 누를 번호가 8일때
        public static String number8(int left, int right, String hand) {

            Map<Integer, Integer> scoreMap8 = Map.of(
                8, 0,                   // position 8의 점수는 0
                5, 1, 7, 1, 9, 1, 0, 1, // position 5, 7, 9, 0의 점수는 1
                4, 2, 6, 2, 2, 2,       // position 4, 6, 2의 점수는 2
                1, 3, 3, 3              // position 1, 3의 점수는 3
            );

            int leftScore = scoreMap8.getOrDefault(left, 2);
            int rightScore = scoreMap8.getOrDefault(right, 2);

            String answer = compare(leftScore, rightScore, hand);
            return answer;

        }    
    
        // 누를 번호가 0일때
        public static String number0(int left, int right, String hand) {

            Map<Integer, Integer> scoreMap0 = Map.of(
                0, 0,               // position 0의 점수는 0
                8, 1,               // position 8의 점수는 1
                7, 2, 9, 2, 5, 2,   // position 5, 7, 9의 점수는 2
                4, 3, 6, 3, 2, 3,   // position 2, 4, 6의 점수는 3
                1, 4, 3, 4          // position 1, 3의 점수는 4
            );

            int leftScore = scoreMap0.getOrDefault(left, 1);
            int rightScore = scoreMap0.getOrDefault(right, 1);

            String answer = compare(leftScore, rightScore, hand);
            return answer;

        }
        
    
        // 점수 비교 메서드
        public static String compare(int leftScore, int rightScore, String hand){
            // 점수 비교 후, 같은 점수일 경우 'hand'에 맞게 선택
            if (leftScore == rightScore) {
                if (hand.equals("right")) {
                    return "R";
                } else {
                    return "L";
                }
            }

            // 점수가 같지 않다면 더 낮은 쪽을 선택
            return leftScore < rightScore ? "L" : "R"; 
    }
}
