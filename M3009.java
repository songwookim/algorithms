import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class M3009 {
    public static void main(String[] args) throws IOException {
        int X[] = new int[3];
        int Y[] = new int[3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }
        double grad1 = grad(new int[] {X[0], Y[0]},new int[]  {X[1], Y[1]});
        double grad2 = grad(new int[] {X[0], Y[0]},new int[]  {X[2], Y[2]});
        double grad3 = grad(new int[] {X[1], Y[1]},new int[]  {X[2], Y[2]});

        int a1, b1, a2,b2;
        double d1,d2;
        if(grad1 * grad2 == -1) {
            d1 = grad1;
            d2 = grad2;
            a1 = X[2];
            b1 = X[2];
            a2 = X[1];
            b2 = X[1];
        } else if(grad1 * grad3 == -1) {
            d1 = grad1;
            d2 = grad3;
            a1 = X[2];
            b1 = X[2];
            a2 = X[0];
            b2 = X[0];
        } else {
            d1 = grad2;
            d2 = grad3;
            a1 = X[1];
            b1 = X[1];
            a2 = X[0];
            b2 = X[0];
        }
        double x = (b2-b1 - d2*a2 + d1*a1) / (d1-d2);
        double y = d1*(x-a1) +b1;
        System.out.println((int)x +" "+ (int)y);
    }

    static double grad (int[] arr1, int[] arr2){
        if(arr1[0] == arr2[0]) return 0;
        return (arr1[1]-arr2[1])/(arr1[0]-arr2[0]);
    }
}
