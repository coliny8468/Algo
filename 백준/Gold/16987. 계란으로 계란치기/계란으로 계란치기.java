import java.util.Scanner;

public class Main {
    static int N; // 계란의 수
    static int[][] eggs; // 계란 정보 (내구도, 무게)
    static int maxBroken = 0; // 최대 깨진 계란 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 계란 개수와 정보 입력
        N = sc.nextInt();
        eggs = new int[N][2];
        for (int i = 0; i < N; i++) {
            eggs[i][0] = sc.nextInt(); // 내구도
            eggs[i][1] = sc.nextInt(); // 무게
        }

        // 재귀 시작
        dfs(0);
        System.out.println(maxBroken);
    }

    // 재귀 함수
    static void dfs(int index) {
        // 모든 계란을 한 번씩 들고 난 후 종료
        if (index == N) {
            // 깨진 계란 개수 세기
            int brokenCount = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i][0] <= 0) brokenCount++;
            }
            maxBroken = Math.max(maxBroken, brokenCount);
            return;
        }

        // 현재 계란이 이미 깨졌다면 다음으로 넘어감
        if (eggs[index][0] <= 0) {
            dfs(index + 1);
            return;
        }

        boolean hit = false; // 칠 수 있는 계란이 있는지 확인

        // 다른 계란을 칠지 결정
        for (int i = 0; i < N; i++) {
            if (i == index || eggs[i][0] <= 0) continue; // 자신이거나 이미 깨진 계란이면 스킵

            // 충돌 처리
            eggs[index][0] -= eggs[i][1];
            eggs[i][0] -= eggs[index][1];
            hit = true;

            // 다음 단계로 재귀 호출
            dfs(index + 1);

            // 상태 복구 (백트래킹)
            eggs[index][0] += eggs[i][1];
            eggs[i][0] += eggs[index][1];
        }

        // 칠 수 있는 계란이 없으면 다음 단계로 넘어감
        if (!hit) {
            dfs(index + 1);
        }
    }
}
