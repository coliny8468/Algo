import java.util.*;
import java.io.*;

/**
 * 백준 16974
 * 레벨 햄버거
 * 골드5
 * https://www.acmicpc.net/problem/16974
 */
public class Main {

    static long[] burgerSize;
    static long[] pattyCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Long.parseLong(st.nextToken());

        burgerSize = new long[N + 1];
        pattyCount = new long[N + 1];
        burgerSize[0] = 1;
        pattyCount[0] = 1;

        for(int i = 1; i <= N; i++) {
            burgerSize[i] = burgerSize[i - 1] * 2 + 3;
            pattyCount[i] = pattyCount[i - 1] * 2 + 1;
        }


        System.out.println(countPatty(N, X));

    }

    public static long countPatty(int level, long x) {

        if(level == 0) {
            return 1;
        }

        if(x == 1) {
            return 0;
        }

        long preSize = burgerSize[level - 1];

        if(x <= preSize + 1) {
            return countPatty(level - 1, x - 1);
        } else if(x == preSize + 2) {
            return pattyCount[level - 1] + 1;
        } else {
            return pattyCount[level - 1] + 1 + countPatty(level - 1, x - preSize - 2);
        }

    }
}