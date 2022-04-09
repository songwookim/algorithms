import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class M11279최대힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int input, result ;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        while (n-- > 0) {
            input = Integer.parseInt(br.readLine());

            if (input == 0) {
                result = priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
                System.out.println(result);
            } else {
                priorityQueue.add(input);

            }
        }

    }
}
