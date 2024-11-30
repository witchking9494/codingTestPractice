// 콜라츠 추측
// https://school.programmers.co.kr/learn/courses/30/lessons/12943

class Solution {
    public int solution(int num) {
        
        int count = 0;
        long newNum = num; // int로 진행할 경우, 범위 초과 문제 때문에 오류 발생할 수 있음
        
        while(count < 500) {
            
            // num이 1이라면 return
            if(newNum==1){
                return count;
            }
            
            // 반복문 수행할때마다 count
            count++;
            
            // 입력된 수가 짝수라면 2로 나눕니다. 
            // 입력된 수가 홀수라면 3을 곱하고 1을 더합니다. 
            if(newNum%2==0){
                newNum /= 2;
            } else {
                newNum = (newNum*3)+1;
            }
        }

        // 500번 반복할 때까지 1이 되지 않는다면 -1 반환
        return -1;
    }
}