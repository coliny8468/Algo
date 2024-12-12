import java.util.*;

public class Main {
    static int n;
    static int m;
    static int move;
    static int nums[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        move = sc.nextInt();
        nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        // 각 레벨에 대해 회전 이동 수행
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            move(i);
        }

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void move(int cnt) {
        // moveNum을 LinkedList로 선언하여 removeFirst() 사용 가능하게 수정
        LinkedList<Integer> moveNum = new LinkedList<>();

        // 반시계방향으로 원형 이동할 숫자들 저장
        // 상 -> 좌 -> 하 -> 우 순서로 이동
        for (int i = cnt; i < m - cnt; i++) {
            moveNum.add(nums[cnt][i]);  // 상단
        }

        for (int i = cnt + 1; i < n - cnt - 1; i++) {
            moveNum.add(nums[i][m - cnt - 1]);  // 우측
        }

        for (int i = m - cnt - 1; i >= cnt; i--) {
            moveNum.add(nums[n - cnt - 1][i]);  // 하단
        }

        for (int i = n - cnt - 2; i > cnt; i--) {
            moveNum.add(nums[i][cnt]);  // 좌측
        }

        // 회전 시키기 (move 횟수만큼)
        for (int i = 0; i < move; i++) {
            int a = moveNum.removeFirst(); // 앞에서 빼기
            moveNum.add(a); // 뒤에 추가
        }

        // 배열에 다시 반시계방향 순서대로 삽입
        // 좌 -> 상 -> 우 -> 하 순서로 배열을 채우기
        for (int i = cnt; i < m - cnt; i++) {
            nums[cnt][i] = moveNum.removeFirst();  // 상단
        }

        for (int i = cnt + 1; i < n - cnt - 1; i++) {
            nums[i][m - cnt - 1] = moveNum.removeFirst();  // 우측
        }

        for (int i = m - cnt - 1; i >= cnt; i--) {
            nums[n - cnt - 1][i] = moveNum.removeFirst();  // 하단
        }

        for (int i = n - cnt - 2; i > cnt; i--) {
            nums[i][cnt] = moveNum.removeFirst();  // 좌측
        }
    }
}
