package symmetric;

import symmetric.utils.Matrix;

import java.io.File;

// Rijndael keySize = 128 bits
public class Ex21 implements Result{
    private int size;
    private int[][] m;
    private int[][] roundKey;
    private static final String[][] subBytes =
            Matrix.performToArr(new File("src/symmetric/utils/sources/table.txt").getAbsoluteFile());

    public Ex21(int size, int[][] m, int[][] roundKey) {
        this.size = size;
        this.m = m;
        this.roundKey = roundKey;
    }

    public int[][] getShiftRows(){
        return null;
    }

    public int[][] getState(){
        return null;
    }

    @Override
    public void getResult() {

    }
}
