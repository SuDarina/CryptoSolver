package symmetric;

import java.util.Arrays;

public class Ex32 {
    private final int[] Key = {5, 6, 3, 7, 2, 0, 4, 1};
    private final int length = Key.length;
    private final int[] S = new int[length];

    public void refactorS() {
        int i = 0, j = 0;
        for (int k = 0; k < length; k++) {
            S[k] = k;
        }
        for (int k = 0; k < length; k++) {
            i = k;
            j = (j + S[i] + Key[i % length]) % length;
            System.out.println("i = " + i + ", " + "j = " + j);
            swapS(i, j);
            System.out.println(Arrays.toString(S));
        }
    }

    private void swapS(int i, int j){
        int t = S[i];
        S[i] = S[j];
        S[j] = t;
    }

    public void getK(int clk) {
        int[] K = new int[clk];
        int i = 0, j = 0;
        for (int k = 0; k < clk; k++) {
            ++i;
            j = (j + S[i]) % length;
            swapS(i, j);
            K[clk - 1 - k] = S[(S[i] + S[j]) % length];
        }
        System.out.println(Arrays.toString(K));
    }
}
