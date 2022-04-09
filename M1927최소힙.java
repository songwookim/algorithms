import java.io.*;
import java.util.PriorityQueue;

public class M1927최소힙 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int input;
        while (n-- > 0) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (heap.isEmpty()) {
                    bw.write("0" + "\n");
                } else {
                    bw.write(heap.poll() + "\n");
                }
            } else {
                heap.add(input);
            }
        }
        bw.flush();
    }
}
