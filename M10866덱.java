import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class M10866덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> linkedList = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                int inputNum = Integer.parseInt(st.nextToken());
                if (command.equals("push_front")) {
                    linkedList.addFirst(inputNum);
                    continue;
                }
                linkedList.addLast(inputNum);
            } else {
                switch (command) {
                    case "pop_front":
                    case "pop_back":
                        if (linkedList.isEmpty()) System.out.println(-1);
                        else System.out.println(command.equals("pop_front") ? linkedList.removeFirst() : linkedList.removeLast());
                        break;

                    case "empty":
                        int res = linkedList.isEmpty() ? 1 : 0;
                        System.out.println(res);
                        break;

                    case "size":
                        System.out.println(linkedList.size());
                        break;

                    case "front":
                    case "back":
                        if (linkedList.isEmpty()) System.out.println(-1);
                        else System.out.println(command.equals("front") ? linkedList.getFirst() : linkedList.getLast());
                        break;
                }
            }

        }
    }
}
