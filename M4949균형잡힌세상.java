import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M4949균형잡힌세상 {
    static ArrayList<String> stack;
    static int pointer = 0; // 다음 공간을 가리킴

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        stack = new ArrayList<>();

        String input = br.readLine();
        int length = input.length() ;
        boolean flag ;
        while (!input.equals(".")) {
            flag = true;
            for (int i = 0; i < length && flag; i++) {
                String temp = String.valueOf(input.charAt(i));
                switch (temp) {
                    case "(": case "[":
                        push(temp);
                        break;
                    case ")": case "]":
                        if (!isLastStack(temp)) {
                            sb.append("NO").append("\n");
                            flag = false;
                            break;
                        }
                }
            }
            if (flag) {
                if (stack.isEmpty())
                    sb.append("yes").append("\n");
                else
                    sb.append("no").append("\n");
            }

            input = br.readLine();
            length = input.length();
            stack = new ArrayList<>();
            pointer = 0;
        }
        System.out.println(sb);
    }

    private static void push(String n) {
        stack.add(n);
        pointer++;
    }


    private static String pop() {
        if (pointer == 0) {
            return "";
        }
        return stack.remove(pointer-- - 1);
    }

    private static boolean isLastStack(String input) {
        String temp = pop();
        if (input.equals(")"))
            return "(".equals(temp);
        return "[".equals(temp);
    }
}
