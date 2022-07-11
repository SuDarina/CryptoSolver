package symmetric;

import java.util.Arrays;

public class Ex32 implements Result{
    private final int[] key;
    private final int numberOfElements;


    private final int length;
    private final int[] S;

    public Ex32(int[] key, int numberOfElements) {
        this.key = key;
        this.numberOfElements = numberOfElements;
        length = key.length;
        S = new int[length];
    }

    public void refactorS() {
        int i = 0, j = 0;
        for (int k = 0; k < length; k++) {
            S[k] = k;
        }
        for (int k = 0; k < length; k++) {
            i = k;
            j = (j + S[i] + key[i % length]) % length;
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

    public int[] getK() {
        int[] K = new int[numberOfElements];
        int i = 0, j = 0;
        for (int k = 0; k < numberOfElements; k++) {
            ++i;
            j = (j + S[i]) % length;
            swapS(i, j);
            K[numberOfElements - 1 - k] = S[(S[i] + S[j]) % length];
        }
        return K;
    }

    @Override
    public void getResult(){
        refactorS();
        System.out.println("S after all permutations of the 1st stage: " + Arrays.toString(S));
        System.out.println("First " + numberOfElements + " elements of K: " + Arrays.toString(getK()));

    }
}
