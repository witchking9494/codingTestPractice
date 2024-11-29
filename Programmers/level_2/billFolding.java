// [PCCE 기출문제] 9번 / 지폐 접기
// https://school.programmers.co.kr/learn/courses/30/lessons/340199

class Solution {
    public int solution(int[] wallet, int[] bill) {
        
        int answer = 0;
        int wWidth = wallet[0];
        int wHeight = wallet[1];
        int bWidth = bill[0];
        int bHeight = bill[1];

        // bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 경우 반복문 수행
        while(true){
            
            int wMax = Math.max(wWidth, wHeight);
            int wMin = Math.min(wWidth, wHeight);
            int bMax = Math.max(bWidth, bHeight);
            int bMin = Math.min(bWidth, bHeight);
            
            // bill의 작은 값이 wallet의 작은 값보다 작거나 같고, bill의 큰 값이 wallet의 큰 값보다 작거나 같으면 break
            if(bMin<=wMin && bMax<=wMax){
                break;
            }      
            
            // bill[0]이 bill[1]보다 크다면 bill[0]을 2로 나누고 나머지는 버림
            if (bWidth > bHeight){
                bWidth/=2;
            // 그렇지 않다면 bill[1]을 2로 나누고 나머지는 버림
            } else {
                bHeight/=2;
            }
            // 반복문 수행될 때마다 answer+1
            answer++;
        }
        
        return answer;
    }
}