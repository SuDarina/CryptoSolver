package symmetric.utils;

public class XToDec {
    private String x;
    private int base;

    public XToDec() { }


    public XToDec(String x, int base) {
        this.x = x;
        this.base = base;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int converting() {
        int dec = 0;
        char[] xArr = x.toCharArray();
        for (int i = 0; i < x.length(); i++) {
            dec += (xArr[i] - '0') * Math.pow(base, (x.length() - 1 - i));
        }
        return dec;
    }
}
