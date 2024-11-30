// 2016년
// https://school.programmers.co.kr/learn/courses/30/lessons/12901

import java.time.*;

class Solution {
    public String solution(int a, int b) {
        
        String answer = "";
        
        // 날짜 생성
        LocalDate date = LocalDate.of(2016, a, b);
        // 해당 날짜의 요일
        String dayOfWeek = date.getDayOfWeek().toString();

        // 양식에 맞게 값 변경
        switch (dayOfWeek) {
            case "SUNDAY":
                answer = "SUN";
                break;
            case "MONDAY":
                answer = "MON";
                break;
            case "TUESDAY":
                answer = "TUE";
                break;
            case "WEDNESDAY":
                answer = "WED";
                break;
            case "THURSDAY":
                answer = "THU";
                break;
            case "FRIDAY":
                answer = "FRI";
                break;
            case "SATURDAY":
                answer = "SAT";
                break;
        }
        
        return answer;
    }
}