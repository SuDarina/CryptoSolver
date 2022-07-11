package symmetric;

import symmetric.utils.DecToX;
import symmetric.utils.XToDec;

import java.util.ArrayList;
import java.util.List;

public class Ex11 implements Result{
    private String m;
    private List<String> k;
    private int rounds;

    public Ex11(String m, List<String> k, int rounds) {
        this.m = m;
        this.k = k;
        this.rounds = rounds;
    }

    public String computeNextR(String l0, String r0, String key) {
        XToDec xtd = new XToDec(l0, 2);
        int l0Num = xtd.converting();
        xtd.setX(r0);
        int r0Num = xtd.converting();
        xtd.setX(key);
        int keyNum = xtd.converting();
        return new DecToX(l0Num ^ r0Num ^ keyNum, 2).convertingString();
    }

    private void formatNumber(List<String> l) {
        if (l.get(l.size() - 1).length() < m.length() / 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("0".repeat(Math.max(0, m.length() / 2 - l.get(l.size() - 1).length())));
            sb.append(l.get(l.size() - 1));
            l.set(l.size() - 1, sb.toString());
        }
    }
    public String compute(){
        List<String> l = new ArrayList<>();
        List<String> r = new ArrayList<>();
        if(k.size() != rounds) throw new
                IllegalArgumentException("Number of rounds and amount of keys should be equal");
        l.add(m.substring(0, m.length() / 2));
        r.add(m.substring(m.length() / 2));
        for (int i = 1; i <= rounds; i++) {
            l.add(r.get(i - 1));
            r.add(computeNextR(l.get(i - 1), r.get(i - 1), k.get(i - 1)));
        }
        formatNumber(l);
        formatNumber(r);
        return l.get(l.size() - 1) + r.get(l.size() - 1);
    }

    @Override
    public void getResult() {
        System.out.println("Bits of cipher after " + rounds + " rounds of Feistel: " + compute());
    }

    public static void main(String[] args) {
        Ex11 ex11 = new Ex11("00001100101111000101", List.of("0110011011", "0111011001"), 2);
        ex11.getResult();
    }
}

