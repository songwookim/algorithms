import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class M17298오큰수 {
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            nums[i] = inputNum;

            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                nums[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int tempIndex = stack.pop();
            nums[tempIndex] = -1;
        }
        for (int i : nums) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

//    static private class Stack<T> {
//        private final ArrayList<T> arrayList;
//        private int pointer;
//
//        Stack() {
//            arrayList = new ArrayList<>();
//            pointer = -1;
//        }
//
//        private void push(T item) {
//            arrayList.add(++pointer, item);
//        }
//
//        private T peek() {
//            if (arrayList.isEmpty()) return null;
//            return arrayList.get(pointer);
//        }
//        private int getTopIndex() {
//            return arrayList.size()-1;
//        }
//
//        private T pop() {
//            if (arrayList.isEmpty()) return null;
//            return arrayList.remove(pointer--);
//        }
//
//        private boolean isEmpty() {
//            return arrayList.isEmpty();
//        }
//    }
}
