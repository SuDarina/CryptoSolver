package ex1;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Vigener v = new Vigener("задел");
        System.out.println(v.encrypt("самосборка".toLowerCase(Locale.ROOT)));
        System.out.println(v.decrypt("щаруцшуцпл").toLowerCase(Locale.ROOT));
    }
}
