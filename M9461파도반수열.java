import java.io.*;
import java.util.*;

public class M9461파도반수열 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long[] sequenceResult = new long[101];

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        initsequenceResult();
        for(int i = 0; i < T; i++) {
            int nthNumber = Integer.parseInt(br.readLine());

            bw.write(p(nthNumber) +"\n");
            bw.flush();

        }
    }
    private static long p(int nth) {
        if(sequenceResult[nth] != 0 || nth < 6) {
            return sequenceResult[nth] ;

        }
        return sequenceResult[nth] = p(nth-1) + p(nth-5);

    }
    private static void initsequenceResult() {
        sequenceResult[1] = 1;
        sequenceResult[2] = 1;
        sequenceResult[3] = 1;
        sequenceResult[4] = 2;
        sequenceResult[5] = 2;

//        for(int i = 6; i < 101; i++) {
//            sequenceResult[i] = sequenceResult[i-1] + sequenceResult[i-5] ;
//        }
    }
}