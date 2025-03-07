import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nanugi = sc.nextInt();

        // 뒤 두 자리를 00으로 변경한 값
        int m = (n / 100) * 100;

        // 00~99까지 순차적으로 확인하며 나누어 떨어지는 가장 작은 값 찾기
        for (int i = 0; i < 100; i++) {
            if ((m + i) % nanugi == 0) {
                System.out.printf("%02d%n", i); // 두 자리 형식으로 출력
                return;
            }
        }
    }
}
