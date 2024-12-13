import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        String target = sc.next();
        Stack<Character> stack = new Stack<>();

        // 문자열을 하나씩 스택에 추가하면서 target을 찾아 제거
        for (char c : word.toCharArray()) {
            stack.push(c);  // 문자를 스택에 넣음
            // 스택 크기가 target보다 크고, 스택의 마지막 부분이 target과 같으면
            if (stack.size() >= target.length()) {
                // 마지막 부분이 target과 같으면 제거
                boolean match = true;
                for (int i = 0; i < target.length(); i++) {
                    if (stack.get(stack.size() - target.length() + i) != target.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    // target 문자열을 스택에서 제거
                    for (int i = 0; i < target.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        // 결과를 출력
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : stack) {
                result.append(c);
            }
            System.out.println(result.toString());
        }
    }
}
