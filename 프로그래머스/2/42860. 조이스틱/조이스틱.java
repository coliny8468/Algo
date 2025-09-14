class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;

        // 1️⃣ 글자 변경 횟수 계산
        for(int i=0; i<n; i++){
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 2️⃣ 커서 이동 최적화 계산
        int minMove = n - 1; // 오른쪽만 이동한 경우
        for(int i=0; i<n; i++){
            int next = i + 1;
            while(next < n && name.charAt(next) == 'A') next++;

            // 오른쪽 i까지 이동 후 왼쪽으로 돌아가서 남은 글자 처리
            int move = i + n - next + Math.min(i, n - next);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;

        return answer;
    }
}
