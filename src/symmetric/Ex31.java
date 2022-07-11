package symmetric;

import java.util.*;

public class Ex31 implements Result{

    private final int[] xRates;
    private final int[] shiftReg;
    private final List<Integer> result = new ArrayList<>();

    public Ex31(int[] xRates, int[] shiftReg) {
        this.xRates = xRates;
        this.shiftReg = shiftReg;
    }

    private int moveRight(int[] arr, int leftBit) {
        int resBit = arr[arr.length - 1];
        System.arraycopy(arr, 0, arr, 1, arr.length - 1);
        arr[0] = leftBit;
        return resBit;
    }

    @Override
    public void getResult() {
        int leftBit = 0;
        int[] resA = Arrays.copyOf(shiftReg, shiftReg.length);
        int[] startA = new int[resA.length];
        int rang = 0;

        boolean c = false;

        while (!Arrays.equals(startA, resA)) {
            rang++;
            if(!c){
                startA = Arrays.copyOf(shiftReg, shiftReg.length);
                c = true;
            }
            for (int j : xRates) {
                leftBit += startA[shiftReg.length - j];
            }
            leftBit %= 2;
            System.out.println("left bit: " + leftBit);
            result.add(moveRight(startA, leftBit));
            leftBit = 0;

            System.out.println(Arrays.toString(startA));
        }
        Collections.reverse(result);
        System.out.println("result: " + result);
        System.out.println("rang: " + rang);
    }
}
