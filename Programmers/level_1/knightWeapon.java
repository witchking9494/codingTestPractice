// 기사단원의 무기
// https://school.programmers.co.kr/learn/courses/30/lessons/136798

class Solution {
    public int solution(int number, int limit, int power) {
        
        int answer = 0;        
        
        // number가 limit를 초과하는 경우, 약수 개수 대신 power를 할당
        for(int i = 1; i <= number; i++) {
            if(findDivisors(i) > limit){
                answer += power;
            } else {
                answer += findDivisors(i);
            }
        }
        return answer;
    }
    
    
    // 약수의 개수를 찾는 메소드 (제곱근까지만 계산)
    public static int findDivisors(int number) {        
        int count = 0;
        // 1부터 number까지 반복하며 약수를 구함
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {  // 나누어떨어지면 약수
                count++;
                if (i != number / i) {  // i와 number / i가 동일한 경우, 그 숫자는 중복으로 카운트되는 것을 방지
                    count++;            //  (예: i = 6일 때 36 / 6 = 6)
                }
            }
        }
        return count;        
    }
    
}