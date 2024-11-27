// 월간 코드 챌린지 시즌2 약수의 개수와 덧셈
// https://school.programmers.co.kr/learn/courses/30/lessons/77884

class Solution {
    public int solution(int left, int right) {
        
        int answer = 0;        
        
        // left부터 right까지 반복
        for(int i=left; i <= right; i++) {
            int count = 0;
            // 각 숫자의 약수의 갯수 확인
            for(int j=1; j*j <= i; j++ ){
                if(i%j==0) {
                    count += 2;
                    // j가 i의 제곱근이라면, 중복 집계 피하기 위해 count -= 1
                    if(j*j == i) {
                        count -= 1;
                    }
                }
            }
            
            // 약수의 갯수가 짝수라면 +, 홀수라면 -
            if (count%2==0){
                answer += i;
            } else {
                answer -= i;
            }
        }
                
        return answer;
    }
}