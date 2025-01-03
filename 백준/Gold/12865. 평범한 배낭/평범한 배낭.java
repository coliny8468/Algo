import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 물품 수
        int k = sc.nextInt(); // 최대 무게
        int[] weight = new int[n + 1];
        int[] value = new int[n + 1];
        int[][] dp = new int[n + 1][k + 1];

        // 물건의 무게와 가치 입력
        for (int i = 1; i <= n; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) { // 물건 인덱스
            for (int j = 1; j <= k; j++) { // 무게
                if (j >= weight[i]) { // 물건을 넣을 수 있는 경우
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else { // 물건을 넣을 수 없는 경우
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 결과 출력
        System.out.println(dp[n][k]);
    }
}
