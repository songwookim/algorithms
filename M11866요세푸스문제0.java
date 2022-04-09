import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class M11866요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        Scanner zz = new Scanner(System.in);
        int N = zz.nextInt();
        int K = zz.nextInt();

        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }
        if (N > 1) {
            if (K > 1) {
                int i = 1;
                while (queue.size() > 1) {
                    if (i == K) {
                        sb.append(queue.removeFirst()).append(",").append(" ");
                        i = 1;
                        continue;
                    }
                    queue.addLast(queue.removeFirst());
                    i++;
                }
            } else {
                for (int i = 0; i < N - 1; i++) {
                    sb.append(queue.removeFirst()).append(", ");
                }
            }
        }
        sb.append(queue.removeFirst()).append(">");
        System.out.println(sb);
    }
}
