import java.util.*;

public class Main {
    static int n;
    static int maxEgg = 0;

    static class Egg {
        int weight, durability;

        public Egg(int durability, int weight) {
            this.weight = weight;
            this.durability = durability;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        Egg[] eggs = new Egg[n];

        for (int i = 0; i < n; i++) {
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        }

        breakEgg(eggs, 0);

        System.out.println(maxEgg);

    }

    static void breakEgg(Egg[] eggs, int cnt) {
        if (cnt == n) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].durability <=0) {
                    max++;
                }
            }
            maxEgg = Math.max(max, maxEgg);
            return;
        }

        boolean anyHit = false;

        for (int i = 0; i < n; i++) {
            if (i != cnt && eggs[i].durability > 0 && eggs[cnt].durability > 0) {
                anyHit = true;

                eggs[cnt].durability -= eggs[i].weight;
                eggs[i].durability -= eggs[cnt].weight;

                breakEgg(eggs, cnt + 1);

                eggs[cnt].durability += eggs[i].weight;
                eggs[i].durability += eggs[cnt].weight;
            }
        }
        
        if (!anyHit) {
            breakEgg(eggs, cnt + 1);
        }

    }
}
