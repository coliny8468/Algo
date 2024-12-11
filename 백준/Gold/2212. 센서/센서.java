import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tower = sc.nextInt();
        List<Integer> sensor = new ArrayList<>();

        if (n <= tower) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            sensor.add(sc.nextInt());
        }

        sensor.sort(Comparator.naturalOrder());

        List<Integer> dis = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            dis.add(Math.abs(sensor.get(i) - sensor.get(i + 1)));
        }

        List<Integer> disOrder = new ArrayList<>(dis);
        disOrder.sort(Comparator.reverseOrder());

        // 집중국이 1개일 경우에는 전체 구간 길이를 계산
        if (tower == 1) {
            System.out.println(sensor.get(n - 1) - sensor.get(0));
            return;
        }

        // 집중국이 여러 개일 경우, 가장 큰 간격들을 잘라내고 나머지 구간의 길이 합을 계산
        int totalDistance = sensor.get(n - 1) - sensor.get(0);  // 전체 구간 길이
        int sumOfRemovedDistances = 0;

        // 가장 큰 간격부터 제거
     
        for (int i = 0; i < tower - 1; i++) {
            sumOfRemovedDistances += disOrder.get(i);
        }


        System.out.println(totalDistance - sumOfRemovedDistances);
    }
}
