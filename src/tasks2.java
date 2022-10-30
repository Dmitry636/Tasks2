import java.math.BigDecimal;
import java.util.Arrays; // класс для работы с массивами
import java.util.Collections; // Класс Collections содержит такие методы для работы с коллекциями
// как сортировка, поиск минимума и максимума, реверс, различные преобразования, замены, проверки
// и другое. Также как Arrays класс Collections является статическим.

public class tasks2 {
    public static void main(String[] args) {
        // Task1
        System.out.println("--Task1--");
        System.out.println(repeat("mice", 5));
        System.out.println(repeat("hello", 3));
        System.out.println(repeat("stop", 1));

        // Task2
        System.out.println("--Task2--");
        System.out.println(differenceMaxMin(new int[] {10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(differenceMaxMin(new int[] {44, 32, 86, 19}));

        // Task3
        System.out.println("--Task3--");
        System.out.println(isAvgWhole(new int[]{1, 3}));
        System.out.println(isAvgWhole(new int[]{1, 2, 3, 4}));
        System.out.println(isAvgWhole(new int[]{1, 5, 6}));
        System.out.println(isAvgWhole(new int[]{1, 1, 1}));
        System.out.println(isAvgWhole(new int[]{9, 2, 2, 5}));

        // Task4
        System.out.println("--Task4--");
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{1, -2, 3})));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));

        // Task5
        System.out.println("--Task5--");
        System.out.println(getDecimalPlaces("43.20"));
        System.out.println(getDecimalPlaces("400"));
        System.out.println(getDecimalPlaces("3.1"));

        // Task6
        System.out.println("--Task6--");
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(7));
        System.out.println(Fibonacci(12));

        // Task7
        System.out.println("--Task7--");
        System.out.println(isValid("59001"));
        System.out.println(isValid("853a7"));
        System.out.println(isValid("732 32"));
        System.out.println(isValid("393939"));

        // Task8
        System.out.println("--Task8--");
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));

        // Task9
        System.out.println("--Task9--");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));

        // Task10
        System.out.println("--Task10--");
        System.out.println(boxSeq(0));
        System.out.println(boxSeq(1));
        System.out.println(boxSeq(2));
        System.out.println(boxSeq(3));
        System.out.println(boxSeq(4));
        System.out.println(boxSeq(5));
        System.out.println(boxSeq(6));
    }
    public static String repeat(String s, int n) {
        String d = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < n; j++) {
                d += s.charAt(i);
            }
        }
        return d;
    }

    public static int differenceMaxMin(int[] a) {
        int min = Collections.min(Arrays.stream(a).boxed().toList());
        int max = Collections.max(Arrays.stream(a).boxed().toList());
        return max - min;
    }

    public static boolean isAvgWhole(int[] b) {
        float s = 0;
        for (int i = 0; i < b.length; i++){
            s += b[i];
            if ((s % b.length) == 0) {
                return true;
            }
        }
        return false;
    }

    public static int[] cumulativeSum(int[] c){
        int[] a = new int[c.length];
        int b = 0;
        for (int i = 0; i < c.length; i++) {
            b += c[i];
            a[i] = b;
        }
        return a;
    }

    public static int getDecimalPlaces(String s) {
        return new BigDecimal(s).scale();
    }

    public static int Fibonacci(int n) {
        int[] f = new int[n];
        int s = 0;
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < n; ++i) {
            f[i] = f[i - 1] + f[i - 2];
            s = f[f.length - 1] + f[f.length - 2];
        }
        return s;
    }

    public static boolean isValid(String s){
        return (s.matches("\\d+")) && (s.length() == 5);
    }

    public static boolean isStrangePair(String a, String b){
        if (a.isEmpty() && b.isEmpty()){
            return true;
        }
        int a1 = a.length() - 1;
        int b1 = b.length() - 1;
        return a.charAt(0) == b.charAt(b1) && a.charAt(a1) == b.charAt(0);
    }

    public static boolean isPrefix(String a, String b){
        int b1 = b.length() - 1;
        return b.substring(0, b1).equals(a.substring(0, b1));
    }

    public static boolean isSuffix(String a, String b) {
        int b1 = b.length();
        return b.substring(1, b1).equals(a.substring(b1));
    }

    public static int boxSeq(int a){
        int s = 0;
        for (int i = 1; i <= a; i++){
            if (i % 2 == 0){
                s -= 1;
            } else {
                s += 3;
            }
        }
        return s;
    }
}
