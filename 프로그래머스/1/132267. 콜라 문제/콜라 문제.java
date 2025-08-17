class Solution {
    public int solution(int a, int b, int n) {
        int coke = 0;
        
        while (n >= a) {  // a개 이상일 때만 교환 가능
            int exchanged = (n / a) * b; // 이번에 받은 콜라
            coke += exchanged;
            n = exchanged + (n % a); // 받은 콜라 + 남은 병
        }
        
        return coke;
    }
}
