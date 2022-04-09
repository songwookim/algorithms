import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class M11286절댓값힙_pq_Comparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int input;
        //Integer[] result, arr = new Integer[2];

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                if (Objects.equals(o1[0], o2[0])) {
//                    return o1[1] - o2[1]; // 부호 비교
//                }
//                return o1[0] - o2[0];
                if(Math.abs(o2) == Math.abs(o1))
                    return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        while (n-- > 0) {
            input = Integer.parseInt(br.readLine());
//            arr = new Integer[2];
//            arr[0] = Math.abs(input);
//            arr[1] = input > 0 ? 1 : -1;

            if (input == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
            } else {
                priorityQueue.add(input);
            }
        }
        System.out.println(sb);
    }
}
