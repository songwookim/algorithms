import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class M1158요세푸스문제 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            queue.add(i);
        }
        sb.append("<");
        int count = 0;
        while (count != N - 1) {
            for (int i = 0; i < K - 1; i++) {
                queue.addLast(queue.removeFirst());
            }
            sb.append(queue.removeFirst()).append(", ");
            count++;
        }
        sb.append(queue.removeFirst()).append(">");
        System.out.println(sb);
    }
}
