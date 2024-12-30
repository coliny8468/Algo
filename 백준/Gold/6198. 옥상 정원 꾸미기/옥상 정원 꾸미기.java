import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 빌딩의 개수
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        long result = 0; // 관리인들이 볼 수 있는 빌딩의 수 합 (long 타입)

        for (int i = 0; i < n; i++) {
            // 스택에서 현재 빌딩보다 낮은 빌딩 제거
            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }

            // 스택에 남아 있는 빌딩의 개수가 현재 빌딩이 볼 수 있는 빌딩 수
            result += stack.size();

            // 현재 빌딩을 스택에 추가
            stack.push(heights[i]);
        }

        System.out.println(result);
    }
}
