import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class M1966프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue ;
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int numSize = Integer.parseInt(st.nextToken());
            int orderIdx = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            if(st.countTokens() == 1) {
                sb.append("1\n");
                continue;
            }

            int max=0, min = Integer.MAX_VALUE;
            while (st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                queue.add(input);
                max = Math.max(max, input);
                min = Math.min(min, input);
            }
            int num = queue.get(orderIdx);
            int count = 0;
            while(max != min) {
                for (int k = 0; k < numSize; k++) {
                    if(0 == orderIdx && num == max) {
                        sb.append(count).append("\n");
                        max = min+1;
                        break;
                    }
                    else if(queue.getFirst() < max) {
                        if(orderIdx == 0) orderIdx = queue.size()-1;
                        int removed = queue.removeFirst();
                        orderIdx--;
                        queue.add(removed);
                    } else {
                        queue.removeFirst();
                        orderIdx--;
                        count++;
                    }
                }
                max--;
            }
        }
        System.out.println(sb);
    }
}
