import java.util.*;

public class Ex31 {

    private int[] s = {1, 3, 4};
    private List<Integer> result = new ArrayList<>();


    private int moveRight(int[] arr, int leftBit) {
        int resBit = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = leftBit;
        return resBit;
    }

    public void getResult() {
        int leftBit = 0;
        int[] resA = {1, 1, 0, 0, 0, 1};
        int[] startA = new int[resA.length];
        int rang = 0;

        boolean c = false;

        while (!Arrays.equals(startA, resA)) {
            rang++;
            if(!c){
                startA = new int[]{1, 1, 0, 0, 0, 1};
                c = true;
            }
            for (int i = 0; i < s.length; i++) {
                leftBit += startA[s[i] - 1];
            }
            leftBit %= 2;
            System.out.println("left bit: " + leftBit);
            result.add(moveRight(startA, leftBit));
            leftBit = 0;

            System.out.println(Arrays.toString(startA));
        }
        Collections.reverse(result);
        System.out.println("result: " + result.toString());
        System.out.println("rang: " + rang);
    }
}
