import java.io.*;

public class M8958 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String before_char ;

        for(int i =0; i < N; i++) {
            String[] st = br.readLine().split("");

            before_char = st[0];
            int score = before_char.equals("O")? 1: 0;
            int series = 0;
            int n = 1;

            while(n != st.length) {
                if(st[n].equals("O") ){
                    score++;
                    series = st[n-1].equals("O")? series+1 : 0 ;
                } else {
                    series = 0;
                }
                score += series;
                n++;
            }
            bw.write(score + "\n");
            bw.flush();
        }
        br.close();
        bw.close();

    }
}
