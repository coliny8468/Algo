import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 점의 개수
        int N = sc.nextInt();

        // x, y 값을 저장할 ArrayList
        List<List<Integer>> vX = new ArrayList<>(10001);
        List<List<Integer>> vY = new ArrayList<>(10001);

        // ArrayList 초기화
        for (int i = 0; i < 10001; i++) {
            vX.add(new ArrayList<>());
            vY.add(new ArrayList<>());
        }

        // 점 입력받기
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            vX.get(x).add(y);
            vY.get(y).add(x);
        }

        int sum = 0;

        // 각 x, y 값에 대해 정렬 후 길이 계산
        for (int i = 0; i < 10001; i++) {
            // x좌표와 y좌표를 기준으로 정렬
            Collections.sort(vX.get(i));
            Collections.sort(vY.get(i));

            // x에 대한 길이 계산
            for (int j = 0; j < vX.get(i).size(); j += 2) {
                sum += vX.get(i).get(j + 1) - vX.get(i).get(j);
            }

            // y에 대한 길이 계산
            for (int j = 0; j < vY.get(i).size(); j += 2) {
                sum += vY.get(i).get(j + 1) - vY.get(i).get(j);
            }
        }

        // 결과 출력
        System.out.println(sum);
    }
}
