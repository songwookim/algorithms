import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class M1655가운데를말해요 {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static StringBuffer sb = new StringBuffer();
    private static PriorityQueue<Integer> minHeap, maxHeap;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int input;

        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            input = Integer.parseInt(br.readLine());

            if (!minHeap.isEmpty() && minHeap.peek() > input) {
                maxHeap.add(input);
            } else {
                minHeap.add(input);
            }

            int BF = Math.abs(maxHeap.size() - minHeap.size());
            if(BF == 2) {
                rotate();
            }

            if (minHeap.isEmpty()) {
                sb.append(maxHeap.peek()).append("\n");
            } else if (maxHeap.isEmpty() || minHeap.size() - maxHeap.size() == 1) {
                sb.append(minHeap.peek()).append("\n");
            } else {
                sb.append(Math.min(maxHeap.peek(), minHeap.peek())).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static void rotate() {
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else {
            maxHeap.add(minHeap.poll());
        }
    }
}
