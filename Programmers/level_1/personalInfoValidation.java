// 2023 KAKAO BLIND RECRUITMENT 개인정보 수집 유효기간
// https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;


class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 오늘 날짜 파싱하여 년,월,일로 구분
        String[] todayParts = today.split("\\.");
        int todayYear = Integer.parseInt(todayParts[0]);
        int todayMonth = Integer.parseInt(todayParts[1]);
        int todayDay = Integer.parseInt(todayParts[2]);        
        
        
        // terms 안에 담긴 약관 종류, 유효 기간 매핑
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] termParts = term.split(" ");
            String type = termParts[0];                     // 약관 종류
            int months = Integer.parseInt(termParts[1]);    // 유효 기간
            map.put(type, months);
        }
        
        
        // 파기해야 할 개인정보 번호 담을 ArrayList
        List<Integer> expiredPrivacy = new ArrayList<>();
        
        
        // privacies 안에 담긴 개인정보 수집일자, 약관 종류 구분
        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");           
            String[] collectedDateParts = privacyParts[0].split("\\.");
            int collectedYear = Integer.parseInt(collectedDateParts[0]);    // 년
            int collectedMonth = Integer.parseInt(collectedDateParts[1]);   // 월
            int collectedDay = Integer.parseInt(collectedDateParts[2]);     // 일
            String termType = privacyParts[1];                              // 약관 종류
            
            // 약관에 해당하는 유효기간
            int validityMonths = map.get(termType);

            // 개인정보 유효기간 만료된 날짜 계산 (수집 날짜에 유효기간을 더함)\
            // 합한 개월 수가 12 넘으면 별도 계산 
            collectedMonth += validityMonths;
            if (collectedMonth > 12) {
                collectedYear += (collectedMonth - 1) / 12;
                collectedMonth = (collectedMonth - 1) % 12 +1;
            } 

                        
            // 유효기간 만료일을 today와 비교하기 위해 계산한 날짜를 월 단위로 변환
            // today가 유효기간을 넘어서면 파기
            if (collectedYear < todayYear || 
               (collectedYear == todayYear && collectedMonth < todayMonth) || 
               (collectedYear == todayYear && collectedMonth == todayMonth && collectedDay <= todayDay)) {
                expiredPrivacy.add(i + 1);
            }
        }        
        
        // ArrayList<Integer>를 int[] 배열로 변환
        return expiredPrivacy.stream().mapToInt(i -> i).toArray();
    }
}