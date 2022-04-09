import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class M13305주유소 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BigInteger[] nodes, edges;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        edges = new BigInteger[N - 1];
        nodes = new BigInteger[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (!st1.hasMoreTokens()) {
                nodes[i] = BigInteger.valueOf(Long.parseLong(st2.nextToken()));
                //nodes[i] = Integer.parseInt(st2.nextToken());
                break;
            }
            edges[i] = BigInteger.valueOf(Long.parseLong(st1.nextToken()));
            nodes[i] = BigInteger.valueOf(Long.parseLong(st2.nextToken()));
            //edges[i] = Integer.parseInt(st1.nextToken());
            //nodes[i] = Integer.parseInt(st2.nextToken());
        }

        BigInteger cost = BigInteger.ZERO;
        for (int i = 0; i < N - 1; ) {
            BigInteger tempSum = edges[i];
            int j;
            for (j = i + 1; j < N - 1; j++) {
                if(nodes[i].compareTo(nodes[j]) > 0) {
                //if (nodes[i] > nodes[j]) {
                    break;
                }
                tempSum = edges[j].add(tempSum);
                //tempSum += edges[j];
            }
            BigInteger a = nodes[i].multiply(tempSum);
            cost = a.add(cost);
            //cost += nodes[i] * tempSum;
            i = j;
        }

        bw.write(cost + "");
        bw.flush();
    }
}
