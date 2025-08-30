import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        // 인접 리스트로 그래프 구성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // 거리/방문 배열
        int[] memoDis = new int[n + 1];
        boolean[] memoV = new boolean[n + 1];
        Arrays.fill(memoDis, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        memoDis[1] = 0;  // 시작점 거리 0
        memoV[1] = true;

        // BFS 탐색
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (!memoV[next]) {
                    memoV[next] = true;
                    memoDis[next] = memoDis[now] + 1; // 현재 거리 + 1
                    q.add(next);
                }
            }
        }

        // 최대 거리 찾기
        int maxDis = 0;
        for (int i = 1; i <= n; i++) {
            if (memoDis[i] != Integer.MAX_VALUE) {
                maxDis = Math.max(maxDis, memoDis[i]);
            }
        }

        // 최대 거리 개수 세기
        for (int i = 1; i <= n; i++) {
            if (memoDis[i] == maxDis) {
                answer++;
            }
        }

        return answer;
    }
}
