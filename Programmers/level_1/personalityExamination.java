// 2022 KAKAO TECH INTERNSHIP 성격 유형 검사하기
// https://school.programmers.co.kr/learn/courses/30/lessons/118666

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String temp = "";
        int R = 0;  // 라이언
        int T = 0;  // 튜브
        int C = 0;  // 콘
        int F = 0;  // 프로도
        int J = 0;  // 제이지
        int M = 0;  // 무지
        int A = 0;  // 어피치
        int N = 0;  // 네오
        
        // survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"
        // choices의 원소는 1, 2, 3, 4, 5, 6, 7
        // 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지 (1, 2, 3)
        // 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지 (5 ,6 ,7)
        // 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 (R, C, J, A)        
    
        // 성격유형과 그 점수를 모두 합하기 위한 for문
        // ex : temp 안에는 "R1T2C3T1" 이런 식으로 값이 담김
        for(int i=0 ; i < choices.length ; i++) {
            temp += calculator(survey[i], choices[i]);
        }

        
        // temp에 담긴 값을 이용하여 각 성격 유형의 최종 점수 계산
        for (int i = 0; i < temp.length(); i += 2) {
            char letter = temp.charAt(i);                               // 홀수 자리 알파벳
            int score = Character.getNumericValue(temp.charAt(i + 1));  // 짝수 자리 숫자
            
            // 각 알파벳에 해당하는 점수 합산
            switch (letter) {
                case 'R':
                    R += score;
                    break;
                case 'T':
                    T += score;
                    break;
                case 'C':
                    C += score;
                    break;
                case 'F':
                    F += score;
                    break;
                case 'J':
                    J += score;
                    break;
                case 'M':
                    M += score;
                    break;
                case 'A':
                    A += score;
                    break;
                case 'N':
                    N += score;
                    break;                    
            }
        }
        
        // 점수 비교 후 최종 결과 제출
        if (R >= T) {
            answer += "R";
        } else {
            answer += "T";
        }
        if (C >= F) {
            answer += "C";
        } else {
            answer += "F";
        }
        if (J >= M) {
            answer += "J";
        } else {
            answer += "M";
        }
        if (A >= N) {
            answer += "A";
        } else {
            answer += "N";
        }        
        
        return answer;
    }
    
    
    
    // 점수 계산용 메서드
    // 첫 번째 자리에는 성격 유형, 두 번째 자리에는 점수 (ex: R1)
    public String calculator (String character, int score) {
        
        String result = "";
        
        if (score == 4) {
            result += character.charAt(0);
            result += "0";
        } else if (score < 4) {     // 비동의 관련 선택지 
            result += character.charAt(0);
            // 계산된 값을 변환 (1과 3을 서로 바꾸도록)
            String change  = switch (score) {
                case 1 -> "3";  // 1이면 3으로 변환
                case 3 -> "1";  // 3이면 1로 변환
                default -> "2"; // 2는 그대로 유지
            };
            result += change;            
        } else {                    // 동의 관련 선택지
            result += character.charAt(1);
            result += Integer.toString(score-4);
        }       
                
        return result;
    }  
        
}