import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger n = new BigInteger(sc.next()); // 전체 금액
        BigInteger m = new BigInteger(sc.next()); // 생명체 수

        System.out.println(n.divide(m)); // 몫: 1명당 금액
        System.out.println(n.remainder(m)); // 나머지: 남은 돈
    }
}