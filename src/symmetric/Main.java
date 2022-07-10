package symmetric;

public class Main {
    public static void main(String[] args) {
        Ex32 ex32 = new Ex32(new int[]{5, 6, 3, 7, 2, 0, 4, 1}, 5);
        ex32.getResult();

        System.out.println();

        Ex31 ex31 = new Ex31(new int[]{6, 4, 3}, new int[]{1, 1, 0, 0, 0, 1});
        ex31.getResult();
    }
}
