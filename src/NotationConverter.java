import java.util.Scanner;

public class NotationConverter {
    public static void main(String[] args) {
        NotationConverter notationConverter = new NotationConverter();

        try {
            System.out.println(notationConverter.toArabic());
        } catch (IllegalArgumentException e) {
            System.out.println("String must contain only valid roman numerals\n" +
                    "[I, V, X, L, C, D, M].");
            throw e;
        }
    }

    public int toArabic() throws IllegalArgumentException {
        enum Roman {
            I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
            private final int value;
            Roman(int value) {
                this.value = value;
            }
            public int toInt() {
                return value;
            }
        }

        Scanner console = new Scanner(System.in);
        System.out.println("Введите римское число: ");
        String romanNotation = console.nextLine();
        char[] numToArray = romanNotation.toCharArray();
        int sum = 0;
        for (int i = 0; i < numToArray.length; i++) {
            int a = Roman.valueOf(String.valueOf(numToArray[i])).toInt();
            if (i < numToArray.length - 1) {
                int b = Roman.valueOf(String.valueOf(numToArray[i+1])).toInt();
                if (a < b) {
                    sum += (b - a);
                    i++;
                }
                else sum += a;
            }
            else sum += a;
        }
        return sum;
    }
}
