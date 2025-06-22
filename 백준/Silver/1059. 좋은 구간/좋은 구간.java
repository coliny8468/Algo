import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int[] s = new int[l];
        for (int i = 0; i < l; i++) {
            s[i] = sc.nextInt();
        }
        int n = sc.nextInt();

        Arrays.sort(s);

        // n이 집합에 있으면 좋은 구간 X
        for (int num : s) {
            if (num == n) {
                System.out.println(0);
                return;
            }
        }

        // n을 기준으로, n보다 작은 수와 큰 수 중 가장 가까운 두 수 찾기
        int left = 0;
        int right = 1001;

        for (int num : s) {
            if (num < n) left = num;
            else if (num > n && num < right) right = num;
        }

        // [left+1, right-1]에서 n을 포함하고 A < B 조건 만족하는 모든 (A,B) 쌍 개수 구하기
        int count = 0;
        for (int a = left + 1; a <= n; a++) {
            for (int b = n; b < right; b++) {
                if (a < b) count++;
            }
        }

        System.out.println(count);
    }
}
