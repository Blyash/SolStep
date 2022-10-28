import java.io.BufferedReader;
import java.util.*;
import java.io.InputStreamReader;


public class HmSolV2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s == null || s.isEmpty()) {
                break;
            }
            list.add(s);
        }
        String[] array = list.toArray(new String[0]);
        sort(array);
        for (String x : array) {
            System.out.println(x);
        }
    }
    public static void sort(String[] array) {
        List<Integer> numbers = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (String s : array) {
            if (isNumber(s))
                numbers.add(Integer.parseInt(s));
            else
                strings.add(s);
        }
        numbers.sort(Collections.<Integer>reverseOrder());
        Collections.sort(strings);
        isGreaterThan("", "_");
        int numberCount = 0;
        int stringCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = numbers.get(numberCount) + "";
                numberCount++;
            } else {
                array[i] = strings.get(stringCount);
                stringCount++;
            }
        }
    }
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}