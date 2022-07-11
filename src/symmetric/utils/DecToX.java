package symmetric.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DecToX {
    private int dec;
    private int base;

    public DecToX(int dec, int base) {
        this.dec = dec;
        this.base = base;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public Integer[] convertingIntArr() {
        List<Integer> res = new ArrayList<>();
        int decimal = dec;
        while(decimal >= base) {
            res.add((decimal % base ));
            decimal /= base;
        }
        res.add(decimal);
        for (int i = 0; i < res.size() / 2; i++) {
            Collections.swap(res, i, res.size() - 1 - i);
        }
        return res.toArray(new Integer[0]);
    }

    public String convertingString(){
        Integer[] res = convertingIntArr();
        List<Character> chars = Arrays.stream(res).map(e -> e.toString().toCharArray()[0]).collect(Collectors.toCollection(ArrayList<Character>::new));
        StringBuilder sb = new StringBuilder();
        for(char c : chars) sb.append(c);
        return sb.toString();
    }
}
