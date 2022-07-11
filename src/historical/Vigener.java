package historical;

import historical.utils.AlphabetWork;

import java.util.List;

public class Vigener {
    private String key;
    private char[] keyString;
    private char[] word;

    public Vigener() {
    }

    public Vigener(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private final Character[][] vigSquare = getVigSquare();
    private static final AlphabetWork aw = new AlphabetWork();

    public Character[][] getVigSquare() {
        int num = aw.getCyrillicNum();
        Character[][] vigSquare = new Character[num][num];
        for (int i = 0; i < aw.getCyrillicNum(); i++) {
            vigSquare[i] = aw.moveAlphabetRight(i);
        }
        return vigSquare;
    }

    public void cryptHelper(String wordToCrypt){
        char[] keyChars = key.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() != wordToCrypt.length()) {
            sb.append(keyChars[i++]);
            i = i > key.length() - 1 ? 0 : i;
        }
        keyString = sb.toString().toCharArray();
        word = wordToCrypt.toCharArray();
    }

    public String encrypt(String wordToEncrypt) {
        cryptHelper(wordToEncrypt);
        char[] results = new char[word.length];
        for (int j = 0; j < word.length; j++) {
            results[j] = vigSquare[List.of(aw.getCyrillicAlphabet()).indexOf(word[j])]
                    [List.of(aw.getCyrillicAlphabet()).indexOf(keyString[j])];
        }

        return new String(results);
    }
    public String decrypt(String wordToDecrypt) {
        cryptHelper(wordToDecrypt);
        char[] results = new char[word.length];
        for (int j = 0; j < word.length; j++) {
            Character[] alphabet = aw.getCyrillicAlphabet();
            results[j] = alphabet[List.of(vigSquare[List.of(aw.getCyrillicAlphabet()).indexOf(keyString[j])]).indexOf(word[j])];
        }

        return new String(results);
    }
}
