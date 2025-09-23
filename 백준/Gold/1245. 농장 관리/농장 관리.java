import java.util.*;

public class Main {

    static int n, m, cnt;
    static int[][] map;
    static boolean[][] v;
    static int[][] dir = {
        {0,1},{1,0},{-1,0},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        v = new boolean[n][m];
        cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!v[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        v[x][y] = true;
        boolean isPeak = true;

        int h = map[x][y]; // 시작점 높이

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < dir.length; i++) {
                int nx = cx + dir[i][0];
                int ny = cy + dir[i][1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (map[nx][ny] > h) {
                        // 주변에 더 높은 칸이 있으면 산봉우리 아님
                        isPeak = false;
                    } else if (map[nx][ny] == h && !v[nx][ny]) {
                        // 같은 높이만 큐에 넣고 방문 처리
                        v[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                    // 낮은 칸은 큐에 넣지 않고 방문 처리 X
                }
            }
        }

        if (isPeak) cnt++;
    }
}
