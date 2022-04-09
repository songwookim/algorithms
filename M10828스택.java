import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class M10828스택 {
    static ArrayList<Integer> stack;
    static int pointer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        stack = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int n = Integer.parseInt(st.nextToken());
                push(n);
                continue;
            }
            sb.append(doCommand(command)).append("\n");
        }
        System.out.println(sb);
    }

    private static int doCommand(String command) {
        switch (command) {
            case "pop":
                if (stack.isEmpty()) return -1;
                int pop = stack.get(pointer - 1);
                stack.remove(pointer - 1);
                pointer--;
                return pop;

            case "size":
                return stack.size();

            case "empty":
                if (stack.isEmpty()) return 1;
                return 0;

            case "top":
                if (stack.isEmpty()) return -1;
                return stack.get(pointer - 1);
        }
        return 0;
    }

    private static void push(int n) {
        stack.add(n);
        pointer++;
    }

}
