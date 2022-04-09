import java.io.*;
import java.util.*;

public class M11650좌표정렬하기_Comparator {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            int tempX = Integer.parseInt(st.nextToken());
            int tempY = Integer.parseInt(st.nextToken());

            hashMap.computeIfAbsent(tempX, k -> new ArrayList<>());
            hashMap.get(tempX).add(tempY);
        }

        List<Integer> sortedList = new ArrayList<>(hashMap.keySet());
        Collections.sort(sortedList);
        for (int key : sortedList
        ) {
            ArrayList<Integer> arrayList = hashMap.get(key);

            arrayList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            for (int y : arrayList
            ) {
                bw.write(key + " " + y + "\n");
            }
        }

        bw.flush();
    }
}
