import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class M18258큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        Queue queue = new Queue();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                queue.enQueue(n);
            } else {
                switch (command) {
                    case "pop" -> sb.append(queue.deQueue()).append("\n");
                    case "empty" -> sb.append(queue.isEmpty()).append("\n");
                    case "size" -> sb.append(queue.size()).append("\n");
                    case "front" -> sb.append(queue.front()).append("\n");
                    case "back" -> sb.append(queue.rear()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

class Queue {
    private final LinkedList<Integer> linkedList;

    Queue() {
        linkedList = new LinkedList<>();
    }

    void enQueue(Integer n) {
        linkedList.addLast(n);
    }

    int deQueue() {
        if (linkedList.isEmpty()) return -1;
        return linkedList.pop();
    }

    int isEmpty() {
        return linkedList.isEmpty() ? 1 : 0;
    }

    int size() {
        return linkedList.size();
    }

    int front() {
        if (linkedList.isEmpty()) return -1;
        return linkedList.getFirst();
    }

    int rear() {
        if (linkedList.isEmpty()) return -1;
        return linkedList.getLast();
    }
}

//class QueueA {
//    private static final int DEFAULT_CAPACITY = 64;
//
//    private Object[] array;
//    private int size;
//
//    private int front;
//    private int rear;
//
//    QueueA() {
//        this.array = new Object[DEFAULT_CAPACITY];
//        this.size = 0;
//        this.front = 0;
//        this.rear = 0;
//    }
//
//    QueueA(int capacity) {
//        this.array = new Object[capacity];
//        this.size = 0;
//        this.front = 0;
//        this.rear = 0;
//    }
//
//    // 동적할당 + 늘리면서 앞부분 부터 재정렬
//    // 이후 용량이 가득 찼을 경우 resize(array.length * 2)를 해서 용적을 2배로 늘린다.
//    private void resize(int newCapacity) {
//        int arrayCapacity = array.length;
//
//        Object[] newArray = new Object[newCapacity];
//
//        for (int i = 1, j = front+1; i <= size; i++, j++) {
//            newArray[i] = array[j % arrayCapacity];
//        }
//
//        this.array= newArray;
//
//        front = 0;
//        rear = size;
//    }
//}