package historical;

import java.util.Arrays;

public class AlphabetWork {
    private final int cyrillicNum = 33;
    private final Character[] cyrillicAlphabet = fillAlphabet();

    public int getCyrillicNum() {
        return cyrillicNum;
    }

    public Character[] getCyrillicAlphabet() {
        return cyrillicAlphabet;
    }

    private Character[] fillAlphabet() {
        Character[] cyrillicAlphabet = new Character[cyrillicNum];
        int i = 0;
        for(char s = 'а'; s <= 'я'; s++) {
            cyrillicAlphabet[i] = s;
            if(s == 'е') cyrillicAlphabet[++i] = 'ё';
            i++;
        }
        return cyrillicAlphabet;
    }

    public Character[] moveAlphabetRight(int step) {
        Character[] cyrillicAlphabet = fillAlphabet();
        Character[] firstLetters = Arrays.copyOf(cyrillicAlphabet, step);
        System.arraycopy(cyrillicAlphabet, step, cyrillicAlphabet,
                0, cyrillicAlphabet.length - step);
        if (cyrillicAlphabet.length - (cyrillicAlphabet.length - step) >= 0)
            System.arraycopy(firstLetters, cyrillicAlphabet.length - step + step - cyrillicAlphabet.length,
                    cyrillicAlphabet, cyrillicAlphabet.length - step, cyrillicAlphabet.length -
                            (cyrillicAlphabet.length - step));
        return cyrillicAlphabet;
    }

}
