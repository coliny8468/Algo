import java.util.*;

public class Main {
    static class ClassInfo {
        int num;
        int start;
        int end;

        public ClassInfo(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        List<ClassInfo> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lectures.add(new ClassInfo(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        
        // 강의를 "시작 시간" 기준으로 정렬
        Collections.sort(lectures, Comparator.comparingInt(a -> a.start));

        // 종료 시간을 저장할 우선순위 큐 (작은 값이 먼저 나옴)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (ClassInfo lecture : lectures) {
            // 현재 강의의 시작 시간이 가장 빨리 끝나는 강의실의 종료 시간보다 크거나 같으면 재사용 가능
            if (!pq.isEmpty() && pq.peek() <= lecture.start) {
                pq.poll(); // 기존 강의실을 제거 (재사용)
            }
            pq.add(lecture.end); // 새로운 강의 종료 시간 추가
        }

        // 필요한 최소 강의실 개수 = 우선순위 큐 크기
        System.out.println(pq.size());
    }
}