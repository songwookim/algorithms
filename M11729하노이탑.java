import java.io.*;

public class M11729하노이탑 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        bw.write((int) Math.pow(2, n) - 1 + "\n");
        hanoi(n, 1, 3, 2);
        bw.flush();
    }

    static void hanoi(int n, int start, int to, int via) throws IOException {
        if (n == 1) {
            bw.write(start +" "+to+ "\n");
            return;
        }
        hanoi(n - 1, start, via, to); // 1 2 3를거쳐
        bw.write(start +" "+to+ "\n");
        hanoi(n - 1, via, to, start); // 2 3 1을거쳐

    }
}