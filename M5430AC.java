import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class M5430AC {
    static StringBuilder sb;
    static LinkedList<Integer> queue;
    static boolean reverseFlag;

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] commands = br.readLine().toCharArray();
            int listLength = Integer.parseInt(br.readLine());
            String stringNums = br.readLine();
            queue = new LinkedList<>();
            sb = new StringBuilder();
            sb.append("[");

            // [1,2,3,4] 숫자만 뽑아 enQueue
            String[] tempNums = stringNums.split("([^0-9])+");
            for (String s : tempNums) {
                if (s.equals("")) continue;
                queue.add(Integer.parseInt(s));
            }

            reverseFlag = false;
            if (!isErrorAfterDoCommands(commands)) {
                if (queue.isEmpty()) {
                    sb.append("]");
                } else {
                    int size = queue.size();
                    int j;
                    for (j = 0; j < size - 1; j++) {
                        int tempNum = reverseFlag ? queue.removeLast() : queue.removeFirst();
                        sb.append(tempNum).append(",");
                    }
                    sb.append(queue.removeLast()).append("]");
                }
            }
            System.out.println(sb);
        }
    }

    private static boolean isErrorAfterDoCommands(char[] commands) {
        reverseFlag = false;
        for (char command : commands) { // 함수 문자열 하나씩 꺼내기
            switch (command) {
                case 'R':
                    reverseFlag = !reverseFlag;
                    break;
                case 'D':
                    if (queue.isEmpty()) {
                        sb = new StringBuilder();
                        sb.append("error");
                        return true;
                    }
                    int removed = reverseFlag ? queue.removeLast() : queue.removeFirst();
                    break;
            }
        }
        return false;
    }
}
