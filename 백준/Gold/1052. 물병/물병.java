import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 현재 물병의 개수
        int k = sc.nextInt(); // 목표 물병의 최대 개수

        int newWater = 0; // 추가로 구매해야 하는 물병의 개수
        while (Integer.bitCount(n) > k) { 
            // 현재 물병의 비트 수가 k보다 많으면
            int lowestBit = n & -n; // 가장 작은 비트 값 (2의 제곱 형태)
            n += lowestBit;         // 물병 추가하여 합칠 준비
            newWater += lowestBit;  // 추가 물병 개수 증가
        }

        System.out.println(newWater); // 최소 추가 물병 개수 출력
    }
}
